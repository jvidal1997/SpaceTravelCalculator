/**
 * This class is intended to manage an array of {@link Trip} objects.
 *
 * @author J. Vidal
 * 09.07.2024
 */
package assignment.data;

import assignment.trip.Trip;
import assignment.util.Metrics;
import assignment.util.SpaceTravelFinancing;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This manages an array of {@link Trip} objects.
 */
public class TripData {

    /**
     * A static array for storing {@link Trip} objects
     */
    protected static final ArrayList<Trip> TRIPS = new ArrayList<>();
    /**
     * Trip departure date
     */
    public static LocalDate departureDate;
    
    /**
     * Adds a {@link Trip} to the <i>TRIPS</i> array of TRIPS.
     * @param trip the trip to be added
     */
    public static void addTrip(Trip trip) {
        TRIPS.add(trip);
    }

    /**
     * Returns the <i>TRIPS</i> array containing {@link Trip} objects.
     * @return a list of {@link Trip} objects
     */
    public static ArrayList<Trip> getTrips() {
        return TRIPS;
    }

    /**
     * This is an explicit default constructor for a class used to store data.
     */
    public TripData() {}

    /**
     * Returns a list of lists containing data for each trip. The first index contains the headers. Each list contains:
     * <ol>
     *     <li>Index (Order #)</li>
     *     <li>Start Planetary Body</li>
     *     <li>Destination Planetary Body</li>
     *     <li>Transportation Vehicle</li>
     *     <li>Max Speed (Km/h)</li>
     *     <li>Distance (Kms)</li>
     *     <li>Duration (Hrs)</li>
     *     <li>Duration (Days)</li>
     *     <li>Daily Member Pay (USD)</li>
     *     <li>Daily Member Food Cost (USD)</li>
     *     <li>Annual Crew Pay (USD)</li>
     *     <li>Annual Food Costs (USD)</li>
     *     <li>Annual Crew Gross Income (USD)</li>
     *     <li>Daily Member Pay (EUR)</li>
     *     <li>Daily Member Food Cost (EUR)</li>
     *     <li>Annual Crew Pay (EUR)</li>
     *     <li>Annual Food Costs (EUR)</li>
     *     <li>Annual Crew Gross Pay (EUR)</li>
     * </ol>
     * @return a list of lists, containing data for each trip
     */
    public static ArrayList<ArrayList<Object>> getTripData() {
        ArrayList<ArrayList<Object>> tripData = new ArrayList<>();
        int rowNumber = 0;

        ArrayList<Object> tripDataRow = new ArrayList<>();
        // Create headers
        tripDataRow.add("Index");
        tripDataRow.add("Departure Date");
        tripDataRow.add("Arrival Date");
        tripDataRow.add("Start");
        tripDataRow.add("Destination");
        tripDataRow.add("Vehicle");
        tripDataRow.add("Vehicle Max Speed (Km/h)");
        tripDataRow.add("Distance (Kms)");
        tripDataRow.add("Duration (Hrs)");
        tripDataRow.add("Duration (Days)");
        tripDataRow.add("GAV (Km/h)");
        tripDataRow.add("GAV with Drag Coeff. (Km/h)");
        tripDataRow.add("TVV with Drag Coeff. (Km/h)");
        tripDataRow.add("Daily Member Pay (USD)");
        tripDataRow.add("Daily Member Food Cost (USD)");
        tripDataRow.add("Annual Crew Pay (USD)");
        tripDataRow.add("Annual Food Costs (USD)");
        tripDataRow.add("Annual Crew Gross Income (USD)");
        tripDataRow.add("Daily Member Pay (EUR)");
        tripDataRow.add("Daily Member Food Cost (EUR)");
        tripDataRow.add("Annual Crew Pay (EUR)");
        tripDataRow.add("Annual Food Costs (EUR)");
        tripDataRow.add("Annual Crew Gross Pay (EUR)");

        tripData.add(tripDataRow);

        for (Trip trip : TRIPS) {
            rowNumber++;
            tripDataRow = new ArrayList<>();
            // Convert trip attributes to PoiElementData objects and append them to the tripDataRow list
            tripDataRow.add(rowNumber);
            tripDataRow.add(trip.getDepartureDate().toString());
            tripDataRow.add(trip.getArrivalDate().toString());
            tripDataRow.add(trip.getStartingPlanet());
            tripDataRow.add(trip.getDestinationPlanet());
            tripDataRow.add(trip.getVehicleName());
            tripDataRow.add(trip.getVehicleSpeed());
            tripDataRow.add(trip.getTripDistance());
            tripDataRow.add(trip.getTravelDurationInHours());
            tripDataRow.add(Metrics.hoursToDay(trip.getTravelDurationInHours()));
            tripDataRow.add(trip.getGAV());
            tripDataRow.add(trip.getGAV_WITH_DRAG());
            tripDataRow.add(trip.getTVV_WITH_DRAG());
            tripDataRow.add(trip.getDailySalaryPerCrewMember());
            tripDataRow.add(trip.getDailyFoodCostPerMember());
            tripDataRow.add(trip.getTotalAnnualEquitableCrewSalary());
            tripDataRow.add(trip.getTotalAnnualEquitableFoodCosts());
            tripDataRow.add(trip.getTotalAnnualCrewGrossIncome());
            tripDataRow.add(SpaceTravelFinancing.USDtoEU(trip.getDailySalaryPerCrewMember()));
            tripDataRow.add(SpaceTravelFinancing.USDtoEU(trip.getDailyFoodCostPerMember()));
            tripDataRow.add(SpaceTravelFinancing.USDtoEU(trip.getTotalAnnualEquitableCrewSalary()));
            tripDataRow.add(SpaceTravelFinancing.USDtoEU(trip.getTotalAnnualEquitableFoodCosts()));
            tripDataRow.add(SpaceTravelFinancing.USDtoEU(trip.getTotalAnnualCrewGrossIncome()));
            tripData.add(tripDataRow);
        }
        return tripData;
    }

    /**
     * Sets the departure date.
     * @param departureDate the departure date
     */
    public static void setDepartureDate(LocalDate departureDate) {
        TripData.departureDate = departureDate;
    }

    /**
     * Returns a string representation of the {@link Trip} objects in the {@link TripData} object.
     * @return a string representation of the array of Trip objects
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Trip trip : TRIPS) {
            string.append(trip.toString()).append("\n");
        }
        return string.toString();
    }
}
