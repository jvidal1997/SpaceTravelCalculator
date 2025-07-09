/**
 * This class is intended to manage a list of {@link TransportationVehicle} objects using the {@link VehicleList} object.
 *
 * @author J. Vidal
 * 09.07.2024
 */
package assignment.data;

import assignment.transportation.TransportationVehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class manages a {@link VehicleList} object that contains a list of {@link TransportationVehicle} objects.
 */
public class TransportationVehicleData {
	/**
	 * A logger for testing methods
	 */
	private static final Logger log = LogManager.getLogger(TransportationVehicleData.class.getName());
	/**
	 * A {@link VehicleList} object for storing a static array of {@link TransportationVehicle} objects
	 */
	public static final VehicleList VEHICLE_LIST = new VehicleList();

	/**
	 * Explicit default constructor that does nothing.
	 */
	public TransportationVehicleData() { /* This is a Plain Old Data Object with no need for instantiation */ }

	/**
	 * This method adds the provided {@link TransportationVehicle} object to the {@link VehicleList} <i>VEHICLE_LIST</i>.
	 * @param vehicle the {@link TransportationVehicle} object to add
	 */
	public static void addVehicle(TransportationVehicle vehicle) {
		VEHICLE_LIST.VEHICLES.add(vehicle);
		log.debug(VEHICLE_LIST.VEHICLES.getLast().toString());
	}

	/**
	 * Compiles an array of Vehicle names from a list of {@link TransportationVehicle} objects in the {@link VehicleList} <i>VEHICLE_LIST</i>
	 * @return an array of strings, representing vehicle names
	 */
	public static String[] getVehicleNames() {
			return VEHICLE_LIST.getNameList().toArray(new String[0]);
	}

	/**
	 * Searches for a vehicle in the array, {@link VehicleList} <i>VEHICLE_LIST</i>, of {@link TransportationVehicle} objects
	 * @param name the name of the vehicle to search for
	 * @return the TransportationVehicle object, or null if not found
	 */
	public static TransportationVehicle getVehicle(String name) {
		return (TransportationVehicle) VEHICLE_LIST.findName(name);
	}

	/**
	 * Sorts the array of {@link TransportationVehicle} objects in the {@link VehicleList} <i>VEHICLE_LIST</i> object, by vehicle name in alphabetical order.
	 */
	public static void sortVehicles() {
		VEHICLE_LIST.sortVehicles();
	}

	/**
	 * Returns a string representation of the {@link TransportationVehicleData} object
	 * @return a string representation of the array of {@link TransportationVehicle} objects
	 */
	public String toString() {
		StringBuilder string = new StringBuilder("\n");
		for (TransportationVehicle vehicle : VEHICLE_LIST.VEHICLES) {
			string.append(vehicle.toString()).append("\n");
		}
		return string.toString();
	}
}
