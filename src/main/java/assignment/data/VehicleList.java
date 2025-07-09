/**
 * This class is intended to store an array of {@link TransportationVehicle} objects.
 * @author J. Vidal
 * 10.02.2024
 */
package assignment.data;

import assignment.transportation.TransportationVehicle;
import edu.ccri.assignment.planets.data.DataAccessElement;
import edu.ccri.assignment.planets.data.DataAccessOperations;

import java.util.ArrayList;
import java.util.List;

/**
 *  This class stores an array of {@link TransportationVehicle} objects
 */
public class VehicleList implements DataAccessOperations {
    /**
     * An array of {@link TransportationVehicle} objects
     */
    public final ArrayList<TransportationVehicle> VEHICLES = new ArrayList<>();

    /**
     * This class stores an array of {@link TransportationVehicle} objects
     */
    public VehicleList() {
        // Do nothing
    }

    /**
     * Searches for a vehicle in the array, {@link VehicleList} <i>VEHICLE_LIST</i>, of {@link TransportationVehicle} objects
     * @param name the name of the vehicle to search for
     * @return the TransportationVehicle object, or null if not found
     */
    public DataAccessElement findName(String name) {
        DataAccessElement found = null;
        for (TransportationVehicle vehicle : VEHICLES) {
            if (vehicle.getName().equals(name)) {
                found = vehicle;
            }
        }
        return found;
    }

    /**
     * Sorts the {@link TransportationVehicle} objects in the <i>VEHICLES</i> array by name in alphabetical order.
     */
    public void sortVehicles(){
        VEHICLES.sort((v1, v2) -> v1.getName().compareTo(v2.getName()));
    }

    /**
     * Compiles a list of Vehicle names from a list of {@link TransportationVehicle} objects in the {@link VehicleList} <i>VEHICLE_LIST</i>
     * @return a list of strings, representing vehicle names
     */
    public List<String> getNameList() {
        List<String> names = new ArrayList<>();
        for (TransportationVehicle vehicle : VEHICLES) {
            names.add(vehicle.getName());
        }
        return names;
    }

}
