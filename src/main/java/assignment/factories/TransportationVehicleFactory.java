/**
 * This is a factory class that creates concrete {@link TransportationVehicle} objects based on type.
 * @author J. Vidal
 * 10.13.2024
 */
package assignment.factories;

import assignment.transportation.TransportationVehicle;
import assignment.transportation.vehicleTypes.airVehicles.*;
import assignment.transportation.vehicleTypes.landVehicles.*;
import assignment.transportation.vehicleTypes.waterVehicles.Boat;
import assignment.transportation.vehicleTypes.waterVehicles.CruiseShip;
import assignment.transportation.vehicleTypes.waterVehicles.Submarine;

/**
 * This is a factory class that creates concrete {@link TransportationVehicle} objects based on type.
 */
public class TransportationVehicleFactory {

    /**
     * This is an empty constructor for the {@link TransportationVehicleFactory} factory class.
     */
    private TransportationVehicleFactory() {
        // do nothing
    }

    /**
     * This method creates a {@link TransportationVehicle} object based on the type.
     * @param type the type of the {@link TransportationVehicle} object
     * @return the {@link TransportationVehicle} object
     */
    public static TransportationVehicle create(String type) {
        return switch (type.toLowerCase()) {
            case "car" -> new Car();
            case "bus" -> new Bus();
            case "train" -> new Train();
            case "motorcycle" -> new Motorcycle();
            case "moon rover" -> new MoonRover();
            case "boat" -> new Boat();
            case "submarine" -> new Submarine();
            case "cruise ship" -> new CruiseShip();
            case "aircraft" -> new Aircraft();
            case "helicopter" -> new Helicopter();
            case "drone" -> new Drone();
            case "spacecraft" -> new Spacecraft();
            case "starship" -> new Starship();
            default -> throw new IllegalArgumentException("Invalid vehicle type: " + type);
        };
    }
}
