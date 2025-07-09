/**
 * This class is used to store the constants in the XML file
 * @author J. Vidal
 * 10.23.2024
 */
package assignment.data;

import assignment.test.TestApplicationProperties;
import edu.ccri.assignment.files.xml.AbstractXmlStaxReadElementDataList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to store the constants in the XML file
 */
public class PlanetaryConstants extends AbstractXmlStaxReadElementDataList {
    /**
     * A logger for the {@link PlanetaryConstants} class
     */
    private static final Logger logger = LogManager.getLogger(PlanetaryConstants.class.getName());
    /**
     * The precision identifier for the current list of constants in the XML file
     */
    String name;
    /**
     * A HashMap to store the current constants
     */
    protected static final Map<String, String> constants = new HashMap<>();
    /**
     * The singleton instance of the {@link PlanetaryConstants} class
     */
    private static PlanetaryConstants planetaryConstants;

    /**
     * A constructor for the {@link PlanetaryConstants} class
     * @param filepath the path to the XML file
     * @throws Exception if the XML file is not found
     */
    private PlanetaryConstants(String filepath) throws Exception {
        super(filepath);
        logger.debug("Constants: {}", constants);
        logger.debug("Constants size: {}", constants.size());
    }

    /**
     * Gets the singleton instance of the {@link PlanetaryConstants} class
     * @return the singleton instance of the {@link PlanetaryConstants} class
     * @throws Exception if the XML file is not found
     */
    public static PlanetaryConstants getInstance() throws Exception {
        if (planetaryConstants == null) {
            planetaryConstants = new PlanetaryConstants(TestApplicationProperties.APP_RESOURCES_PATH + TestApplicationProperties.INPUT_FILE_NAME_PLANETARY_CONSTANTS);
        }
        return planetaryConstants;
    }

    /**
     * Updates the constants for Utility Classes.
     */
    @Override
    protected void processEndChildTag() {
        // Empty method
    }

    /**
     * Appends variables to the constants (HashMap) using the field name to determine its key.
     * @param fieldName - the field name
     * @param value     - the value
     */
    @Override
    protected void processFieldTag(String fieldName, String value) {
        if (fieldName.equalsIgnoreCase("name")) {
            name = value;
        }
        if (name != null) {
            switch (name) {
                case "precise":
                    switch (fieldName) {
                        case "hoursInDay":
                            constants.put("preciseHoursInDay", value);
                            break;
                        case "daysInYear":
                            constants.put("preciseDaysInYear", value);
                            break;
                        case "gravitationalConstant":
                            constants.put("preciseGravitationalConstant", value);
                            break;
                        case "massOfSun":
                            constants.put("preciseMassOfSun", value);
                            break;
                        case "poundsToKilograms":
                            constants.put("precisePoundsToKilograms", value);
                            break;
                        case "kilogramsToPounds":
                            constants.put("preciseKilogramsToPounds", value);
                            break;
                        case "milesToKilometers":
                            constants.put("preciseMilesToKilometers", value);
                            break;
                        case "kilometersToMiles":
                            constants.put("preciseKilometersToMiles", value);
                            name = null;
                            break;
                        default:
                            break;
                    }
                    break;
                case "estimate":
                    switch (fieldName) {
                        case "hoursInDay":
                            constants.put("estimateHoursInDay", value);
                            break;
                        case "daysInYear":
                            constants.put("estimateDaysInYear", value);
                            break;
                        case "gravitationalConstant":
                            constants.put("estimateGravitationalConstant", value);
                            break;
                        case "massOfSun":
                            constants.put("estimateMassOfSun", value);
                            break;
                        case "poundsToKilograms":
                            constants.put("estimatePoundsToKilograms", value);
                            break;
                        case "kilogramsToPounds":
                            constants.put("estimateKilogramsToPounds", value);
                            break;
                        case "milesToKilometers":
                            constants.put("estimateMilesToKilometers", value);
                            break;
                        case "kilometersToMiles":
                            constants.put("estimateKilometersToMiles", value);
                            name = null;
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Gets the constants
     * @return the constants
     */
    public static Map<String, String> getConstants() {
        return constants;
    }
}

