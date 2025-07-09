/**
 *  This class is intended to store the application properties in a {@link Properties} object.
 *  @author J. Vidal
 *  10.12.2024
 */
package assignment.test;

import edu.ccri.assignment.files.text.AbstractPropertyList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * This class is intended to store the application properties in a {@link Properties} object.
 */
public class TestApplicationProperties extends AbstractPropertyList {
    /**
     * A logger for the {@link TestApplicationProperties} class
     */
    private static final Logger logger = LogManager.getLogger(TestApplicationProperties.class.getName());
    /**
     * The path to the application resources
     */
    public static String APP_RESOURCES_PATH;
    /**
     * The name of the space data input file
     */
    public static String INPUT_FILE_NAME;
    /**
     * The name of the input contact file
     */
    public static String INPUT_CONTACT_FILE_NAME;
    /**
     * The name of the planetary constants input file
     */
    public static String INPUT_FILE_NAME_PLANETARY_CONSTANTS;
    /**
     * The prefix of the output file
     */
    public static String OUTPUT_FILE_NAME_PREFIX;
    /**
     * The suffix of the output file
     */
    public static String OUTPUT_FILE_NAME_SUFFIX;
    /**
     * The name of the output worksheet
     */
    public static String OUTPUT_WORKSHEET_NAME;
    /**
     * The name of the output contact worksheet
     */
    public static String OUTPUT_CONTACT_WORKSHEET_NAME;
    /**
     * The prefix of the planetary constants output file
     */
    public static String OUTPUT_FILE_NAME_PLANETARY_CONSTANTS_PREFIX;
    /**
     * The suffix of the planetary constants output file
     */
    public static String OUTPUT_FILE_NAME_PLANETARY_CONSTANTS_SUFFIX;

    /**
     * Creates a new {@link TestApplicationProperties} object
     * @param fileName the path to the properties file
     * @throws IOException if the properties file cannot be read
     */
    public TestApplicationProperties(String fileName) throws IOException {
        super(fileName);
        super.readFile(false);
    }

    /**
     * Extracts the properties from the properties file
     */
    @Override
    public void extractProperties() {
        // Retrieve properties
        Properties properties = getProperties();
        // Log start of process
        logger.debug(new StringBuilder().append("Adding ").append(properties.size()).append(" properties to list from properties file..."));
        // Add property values to list
        for (String key : properties.stringPropertyNames()) {
            addValueToPropertyList(key);
        }
        // Log end of process
        logger.debug("Properties added to list successfully");

        // Set properties to constants for quick retrieval
        APP_RESOURCES_PATH = getProperties().getProperty("app.resources.path");
        INPUT_FILE_NAME= getProperties().getProperty("input.file.name");
        INPUT_CONTACT_FILE_NAME= getProperties().getProperty("input.contact.file.name");
        INPUT_FILE_NAME_PLANETARY_CONSTANTS= getProperties().getProperty("input.file.name.planetary.constants");
        OUTPUT_FILE_NAME_PREFIX= getProperties().getProperty("output.file.name.prefix");
        OUTPUT_FILE_NAME_SUFFIX= getProperties().getProperty("output.file.name.suffix");
        OUTPUT_WORKSHEET_NAME= getProperties().getProperty("output.worksheet.name");
        OUTPUT_CONTACT_WORKSHEET_NAME= getProperties().getProperty("output.contact.worksheet.name");
        OUTPUT_FILE_NAME_PLANETARY_CONSTANTS_PREFIX= getProperties().getProperty("output.file.name.planetary.constants.prefix");
        OUTPUT_FILE_NAME_PLANETARY_CONSTANTS_SUFFIX= getProperties().getProperty("output.file.name.planetary.constants.suffix");
    }
}
