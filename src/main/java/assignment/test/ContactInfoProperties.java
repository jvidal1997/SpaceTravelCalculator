/**
 * This class is intended to store the contact information in a {@link Properties} object.
 * @author J. Vidal
 * 10.12.2024
 */
package assignment.test;

import edu.ccri.assignment.files.text.AbstractPropertyList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * This class is intended to store the contact information in a {@link Properties} object.
 */
public class ContactInfoProperties extends AbstractPropertyList {
    /**
     * A logger for debugging the {@link ContactInfoProperties} class
     */
    private static final Logger logger = LogManager.getLogger(ContactInfoProperties.class.getName());
    /**
     * The name of the assignment
     */
    private static String ASSIGNMENT;
    /**
     * The name of the student
     */
    private static String NAME;
    /**
     * The email of the student
     */
    private static String EMAIL;
    /**
     * The id of the student
     */
    private static String STUDENT_ID;
    /**
     * The date of the assignment
     */
    private static String DATE;
    /**
     * The comments of the student
     */
    private static String COMMENTS;



    /**
     * Creates an instance of the {@link ContactInfoProperties} class by assigning a file name and calling {@link AbstractPropertyList#readFile(boolean)} to store the data from the contact.xml file.
     * @param fileName the name of the file to read
     * @throws IOException if file not found
     */
    public ContactInfoProperties(String fileName) throws IOException {
        super(fileName);
        super.readFile(true);
    }

    /**
     * Extracts the properties from the contact.xml file
     */
    @Override
    public void extractProperties() {
        // Retrieve properties
        Properties properties = getProperties();
        // Log start of process
        logger.debug(new StringBuilder().append("Adding ").append(properties.size()).append(" properties to list from contact info file..."));
        // Add property values to list
        for (String key : properties.stringPropertyNames()) {
            addValueToPropertyList(key);
        }
        // Log end of process
        logger.debug("Properties added to list successfully");

        // Set properties to constants for quick retrieval
        setASSIGNMENT(getProperties().getProperty("assignment"));
        setNAME(getProperties().getProperty("name"));
        setEMAIL(getProperties().getProperty("email"));
        setSTUDENT_ID(getProperties().getProperty("student.id"));
        setDATE(getProperties().getProperty("date"));
        setCOMMENTS(getProperties().getProperty("comments"));
    }

    // SETTERS

    /**
     * Sets the ASSIGNMENT
     * @param ASSIGNMENT the ASSIGNMENT
     */
    public static void setASSIGNMENT(String ASSIGNMENT) {
        ContactInfoProperties.ASSIGNMENT = ASSIGNMENT;
    }

    /**
     * Sets the NAME
     * @param NAME the NAME
     */
    public static void setNAME(String NAME) {
        ContactInfoProperties.NAME = NAME;
    }

    /**
     * Sets the EMAIL *
     * @param EMAIL the EMAIL
     */
    public static void setEMAIL(String EMAIL) {
        ContactInfoProperties.EMAIL = EMAIL;
    }

    /**
     * Sets the STUDENT_ID
     * @param studentId the STUDENT_ID
     */
    public static void setSTUDENT_ID(String studentId) {
        STUDENT_ID = studentId;
    }

    /**
     * Sets the DATE
     * @param DATE the DATE
     */
    public static void setDATE(String DATE) {
        ContactInfoProperties.DATE = DATE;
    }

    /**
     * Sets the COMMENTS
     * @param COMMENTS the COMMENTS
     */
    public static void setCOMMENTS(String COMMENTS) {
        ContactInfoProperties.COMMENTS = COMMENTS;
    }

    // GETTERS

    /**
     * Returns the ASSIGNMENT
     * @return the ASSIGNMENT
     */
    public static String getASSIGNMENT() {
        return ASSIGNMENT;
    }

    /**
     * Returns the NAME
     * @return the NAME
     */
    public static String getNAME() {
        return NAME;
    }

    /**
     * Returns the EMAIL
     * @return the EMAIL
     */
    public static String getEMAIL() {
        return EMAIL;
    }

    /**
     * Returns the STUDENT_ID
     * @return the STUDENT_ID
     */
    public static String getSTUDENT_ID() {
        return STUDENT_ID;
    }

    /**
     * Returns the DATE
     * @return the DATE
     */
    public static String getDATE() {
        return DATE;
    }

    /**
     * Returns the COMMENTS
     * @return the COMMENTS
     */
    public static String getCOMMENTS() {
        return COMMENTS;
    }

}
