/**
 * This class is intended to be a test program that uses several classes to determine how long it will take for various VEHICLES to travel between planetary bodies.
 * @author J. Vidal
 * 09.07.2024
 */
package assignment;

import assignment.data.PlanetaryConstants;
import assignment.test.ContactInfoProperties;
import assignment.test.TestApplicationProperties;
import assignment.test.util.TaskManager;

import java.io.File;

/**
 * A main test program that uses several classes to determine how long it will take for various VEHICLES to travel between planetary bodies, including the costs associated.
 */
public class AppRouter {
	/**
	 * Used to halt the program when an error occurs.
	 */
	private static boolean halted = false;
	/**
	 * A flag that indicates if the GUI should be enabled before the program runs.
	 */
	private static boolean guiEnabled = false;
    /**
	 * This is the main program used for testing a program that determines how long it will take for various VEHICLES to travel between planetary bodies along with the associated costs.
	 * @param file - the input file
	 * @throws Exception if input file not found
	 */
	public static void main(File file) throws Exception {
		// Initialize the program
		initialize(file.exists() ?  file.getAbsolutePath() : "src\\main\\resources\\lesson06\\app.properties");

		// If the file was read successfully, otherwise do nothing
		if (!halted && !guiEnabled) {
			// Run test
			TaskManager.run();
			// Output results
			TaskManager.outputTripResults();
		}
	}

	/**
	 * This method is used to initialize the program.<br><br> It reads and sets properties from the properties and contact info files.<br><br> It reads the input file and stores the data.<br><br>
	 * @param path the path to the properties file
	 * @throws Exception if the input file is not found
	 */
	public static void initialize(String path) throws Exception {
		// Read and set properties from the properties and contact info files
		TestApplicationProperties properties = new TestApplicationProperties(path);
		properties.extractProperties();
		ContactInfoProperties contactInfo = new ContactInfoProperties(TestApplicationProperties.APP_RESOURCES_PATH + TestApplicationProperties.INPUT_CONTACT_FILE_NAME);
		contactInfo.extractProperties();
		@SuppressWarnings("unused")
		PlanetaryConstants constants = PlanetaryConstants.getInstance();
		// Read file and store data
		TaskManager.processDataFile();
	}

	/**
	 * This method is used to enable the GUI.<br><br> It sets the guiEnabled flag to true.<br><br>
	 */
	public static void enableGUI() {
		AppRouter.guiEnabled = true;
	}

	/**
	 * This method returns the guiEnabled flag
	 * @return the guiEnabled flag; true if enabled, false otherwise
	 */
	public static boolean getGUIEnabled() {
		return guiEnabled;
	}

	/**
	 * Sets the halted flag to true.<br><br> This is used to halt the program when an error occurs.
	 */
	public static void halt() {
		halted = true;
	}

	/**
	 * This method returns the halted flag
	 * @return the halted flag; true if halted, false otherwise
	 */
	public static boolean isHalted() {
		return halted;
	}

	/**
	 * This is an explicit default constructor for a class of static methods.
	 */
	private AppRouter(){}
}