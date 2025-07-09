/**
 * This class is intended to manage the sub-processes of the main {@link Test} program.
 * @author J. Vidal
 * 09.07.2024
 */
package assignment.test.util;

import assignment.AppRouter;
import assignment.data.PlanetaryBodyData;
import assignment.data.TransportationVehicleData;
import assignment.data.TripData;
import assignment.planetai.PlanetaryBody;
import assignment.test.ContactInfoProperties;
import assignment.test.TestApplicationProperties;
import assignment.transportation.TransportationVehicle;
import assignment.trip.Trip;
import assignment.util.AbstractUtilityClass;
import edu.ccri.assignment.files.poi.AbstractPoiWriteElementDataList;
import edu.ccri.assignment.files.xml.XmlStaxElementData;
import edu.ccri.assignment.planets.test.dialog.PlanetaryDialog;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.*;

/**
 * This class is intended to manage the sub-processes of the main {@link AppRouter} program.<br><br>
 * Sub Processes:
 * <ul>
 *     <li>Read and store data from an Excel file</li>
 *     <li>Initialize and run the UI for user input</li>
 *     <li>Write trip data to new Excel file</li>
 * </ul>
 */
public class TaskManager {
    /**
     * A logger for testing static methods
     */
    private static final Logger logger = LogManager.getLogger(TaskManager.class.getName());
    /**
     * An instance of the InputFileHandler class used to read the Excel file and store each line of data as an object.
     */
    private static final InputFileHandler DATA = new InputFileHandler();
    /**
     * An instance of the OutputExcelHandler class used to write the trip data to an Excel file.
     */
    private static final OutputExcelHandler OUTPUT_EXCEL = new OutputExcelHandler();
    /**
     * An instance of the OutputXmlHandler class used to write the trip data to an XML file.
     */
    private static final OutputXmlHandler OUTPUT_XML = new OutputXmlHandler();
    /**
     * The file name for the output Excel file
     */
    public static String outputExcelFileName;
    /**
     * The file name for the output XML file
     */
    public static String outputXMLFileName;

    /**
     * This is an explicit default constructor for a class of static methods.
     */
    private TaskManager()  {

    }

    /**
     * Uses the {@link InputFileHandler} class to read an Excel file and convert its data into {@link PlanetaryBody} and
     * {@link TransportationVehicle} objects; then, stores them in separate arrays in the {@link PlanetaryBodyData} and {@link TransportationVehicleData} classes.
     */
    public static void processDataFile() {
        // Read and store data from an Excel file
        DATA.readFileDetails();
    }

    /**
     * Uses the {@link PlanetaryDialog} and {@link UIHandler} classes to run the UI in an infinite loop until the user chooses to stop inputting
     * data.<br><br> Each iteration of the loop will prompt the user for 3 inputs:
     * <ul><li>a starting planet</li> <li>a destination planet</li> <li>a transportation vehicle</li></ul><br> Those details will be used to create
     * a {@link Trip} object that will be appended to an array in the {@link TripData} class
     */
    public static void run() {
        // Instantiate the first PlanetaryDialog object and Date variable
        PlanetaryDialog dialog = new PlanetaryDialog("Departure Date");
        Date travelDate;
        // String nextPlanet;    // Undo this line or assigning next starting planet to current destination for calculating a series of trips
        try{
            // Prompt user for date & accuracy input
            dialog.setUseTravelDate();
            dialog.setUseAccuracy();
            dialog.showMultiEditDialog(new Object[0], new Object[0]);

            // Store accuracy in the Trip class as a static variable
            Trip.setPrecise(dialog.getAccuracy().equalsIgnoreCase("precise"));
            logger.info("Updating constants.");
            AbstractUtilityClass.updateConstants();
            logger.info("Constants updated.");
            // Get travel date and convert to local date; then, store in TripData
            if (dialog.getTravelDate() != null){
                travelDate = dialog.getTravelDate();
                LocalDate localTravelDate = travelDate.toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate();
                TripData.setDepartureDate(localTravelDate);
            }
            else {
                throw new Exception("Program was cancelled by User");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        finally {
            if (dialog.isStop()) {
                AppRouter.halt();
            }
        }

        // Initialize trip input loop
        while (!dialog.isStop() && !AppRouter.isHalted()) {
            // Initialize prompt defaults
            UIHandler.initialize(dialog);

            // Get user input
            UIHandler.getInput(dialog);

            // If user has not stopped, add trip to itinerary
            if (!dialog.isStop()) {
                UIHandler.addTripToItinerary(dialog);

                // Initialize a new PlanetaryDialog object with starting planet from previous trip destination
//                nextPlanet = dialog.getDestinationPlanetName();   // For assigning next starting planet to current destination
                dialog = new PlanetaryDialog("Choose a starting planet:");
//                dialog.setStartingPlanetName(nextPlanet);     // For assigning next starting planet to current destination
            }
        }
    }

    /**
     * Uses the {@link AbstractPoiWriteElementDataList} class to write the trip data to a new Excel file with a unique filename.
     */
    public static void outputTripResults() {
        // Write trip data to new Excel file
        WriteToExcel();
        WriteToXML();
    }

    /**
     * Uses the {@link OutputExcelHandler} class to write the trip data to an Excel file.
     */
    public static void WriteToExcel() {
        // Format contact worksheet
        ArrayList<ArrayList<Object>> contactInfoData = new ArrayList<>();
        contactInfoData.add(new ArrayList<>(Arrays.asList("Assignment", "Name", "Email", "Student ID", "Date", "Comments")));
        contactInfoData.add(new ArrayList<>(Arrays.asList(ContactInfoProperties.getASSIGNMENT(), ContactInfoProperties.getNAME(), ContactInfoProperties.getEMAIL(), ContactInfoProperties.getSTUDENT_ID(), ContactInfoProperties.getDATE(), ContactInfoProperties.getCOMMENTS())));

        if (TripData.getTripData().size() > 1) {
            // Add data to worksheets: contact info
            OUTPUT_EXCEL.addDataListWorksheet( contactInfoData, TestApplicationProperties.OUTPUT_CONTACT_WORKSHEET_NAME);

            // Add data to worksheets: trip data
            OUTPUT_EXCEL.addDataListWorksheet(TripData.getTripData(), TestApplicationProperties.OUTPUT_WORKSHEET_NAME);
            // Write data
            OUTPUT_EXCEL.writeFile();
        }
    }

    /**
     * Uses the {@link OutputXmlHandler} class to write the trip data to an XML file.
     */
    public static void WriteToXML() {
        ArrayList<ArrayList<XmlStaxElementData>> dataList = new ArrayList<>();
        ArrayList<XmlStaxElementData> contactInfoData = new ArrayList<>();
        ArrayList<XmlStaxElementData> constants = new ArrayList<>();
        ArrayList<XmlStaxElementData> tripData = new ArrayList<>();

        // Add data to worksheets: contact info
        contactInfoData.add(new XmlStaxElementData("assignment", ContactInfoProperties.getASSIGNMENT()));
        contactInfoData.add(new XmlStaxElementData("name", ContactInfoProperties.getNAME()));
        contactInfoData.add(new XmlStaxElementData("email", ContactInfoProperties.getEMAIL()));
        contactInfoData.add(new XmlStaxElementData("student_id", ContactInfoProperties.getSTUDENT_ID()));
        contactInfoData.add(new XmlStaxElementData("date", ContactInfoProperties.getDATE()));
        contactInfoData.add(new XmlStaxElementData("comments", ContactInfoProperties.getCOMMENTS()));

        // Append to data list
        dataList.add(contactInfoData);
        OUTPUT_XML.createXml(dataList, "contactInfo");
        dataList = new ArrayList<>();
        // Add data to worksheets: constants
        constants.add(new XmlStaxElementData("precision", Trip.isPrecise() ? "precise" : "estimated"));
        constants.add(new XmlStaxElementData("hoursInDay", AbstractUtilityClass.getHoursInDay()));
        constants.add(new XmlStaxElementData("daysInYear", AbstractUtilityClass.getDaysInYear()));
        constants.add(new XmlStaxElementData("gravitationalConstant", AbstractUtilityClass.getGravitationalConstant()));
        constants.add(new XmlStaxElementData("massOfSun", AbstractUtilityClass.getMassOfSun()));
        constants.add(new XmlStaxElementData("poundsToKilograms", AbstractUtilityClass.getPoundsToKilograms()));
        constants.add(new XmlStaxElementData("kilogramsToPounds", AbstractUtilityClass.getKilogramsToPounds()));
        constants.add(new XmlStaxElementData("milesToKilometers", AbstractUtilityClass.getMilesToKilometers()));
        constants.add(new XmlStaxElementData("kilometersToMiles", AbstractUtilityClass.getKilometersToMiles()));

        // Append to data list
        dataList.add(constants);
        OUTPUT_XML.createXml(dataList, "constants");
        dataList = new ArrayList<>();
        // Add data to worksheets: trip data
        ArrayList<ArrayList<Object>> outputResults = TripData.getTripData();
        for (int i = 1; i < outputResults.size(); i++) {
            // Fetch row
            ArrayList<Object> row = outputResults.get(i);
            // Add row to data list one element at a time
            tripData.add(new XmlStaxElementData("Departure_Date".toLowerCase(), row.get(1).toString()));
            tripData.add(new XmlStaxElementData("Arrival_Date".toLowerCase(), row.get(2).toString()));
            tripData.add(new XmlStaxElementData("Start".toLowerCase(), row.get(3).toString()));
            tripData.add(new XmlStaxElementData("Destination".toLowerCase(), row.get(4).toString()));
            tripData.add(new XmlStaxElementData("Vehicle".toLowerCase(), row.get(5).toString()));
            tripData.add(new XmlStaxElementData("Vehicle_Max_Speed_Km_per_h".toLowerCase(), row.get(6).toString()));
            tripData.add(new XmlStaxElementData("Distance_kms".toLowerCase(), row.get(7).toString()));
            tripData.add(new XmlStaxElementData("Duration_Hrs".toLowerCase(), row.get(8).toString()));
            tripData.add(new XmlStaxElementData("Duration_Days".toLowerCase(), row.get(9).toString()));
            tripData.add(new XmlStaxElementData("GAV_Km_per_h".toLowerCase(), row.get(10).toString()));
            tripData.add(new XmlStaxElementData("GAV_with_Drag_Co_Km_per_h".toLowerCase(), row.get(11).toString()));
            tripData.add(new XmlStaxElementData("TVV_with_Drag_Co_Km_per_h".toLowerCase(), row.get(12).toString()));
            tripData.add(new XmlStaxElementData("Daily_Member_Pay_USD".toLowerCase(), row.get(13).toString()));
            tripData.add(new XmlStaxElementData("Daily_Member_Food_Cost_USD".toLowerCase(), row.get(14).toString()));
            tripData.add(new XmlStaxElementData("Annual_Crew_Pay_USD".toLowerCase(), row.get(15).toString()));
            tripData.add(new XmlStaxElementData("Annual_Food_Costs_USD".toLowerCase(), row.get(16).toString()));
            tripData.add(new XmlStaxElementData("Annual_Crew_Gross_Income_USD".toLowerCase(), row.get(17).toString()));
            tripData.add(new XmlStaxElementData("Daily_Member_Pay_EUR".toLowerCase(), row.get(18).toString()));
            tripData.add(new XmlStaxElementData("Daily_Member_Food_Cost_EUR".toLowerCase(), row.get(19).toString()));
            tripData.add(new XmlStaxElementData("Annual_Crew_Pay_EUR".toLowerCase(), row.get(20).toString()));
            tripData.add(new XmlStaxElementData("Annual_Food_Costs_EUR".toLowerCase(), row.get(21).toString()));
            tripData.add(new XmlStaxElementData("Annual_Crew_Gross_Pay_EUR".toLowerCase(), row.get(22).toString()));

            // Append to data list
            dataList.add(tripData);
            tripData = new ArrayList<>();
        }

        // Set dataList to OutputXmlHandler
        if (TripData.getTripData().size() > 1) {
            OUTPUT_XML.createXml(dataList, "trip-results");
            OUTPUT_XML.writeFile();
        }
    }

    /**
     * Sets the output Excel file name
     * @param fileName the output Excel file name
     */
    public static void setOutputExcelFileName(String fileName) {
        outputExcelFileName = fileName;
    }

    /**
     * Sets the output XML file name
     * @param fileName the output XML file name
     */
    public static void setOutputXMLFileName(String fileName) {
        outputXMLFileName = fileName;
    }

    /**
     * Gets the output Excel file name and returns it
     * @return the output Excel file name
     */
    public static String getOutputExcelFileName() {
        return outputExcelFileName;
    }

    /**
     * Gets the output XML file name and returns it
     * @return the output XML file name
     */
    public static String getOutputXMLFileName() {
        return outputXMLFileName;
    }
}
