/**
 * This class is a specialized subclass of the generalized {@link LandVehicle} class that represents an {@link Train}.
 * @author J. Vidal
 * 10.02.2024
 */
package assignment.transportation.vehicleTypes.landVehicles;

import assignment.transportation.vehicleTypes.LandVehicle;

import java.math.BigDecimal;
/**
 * This class is a specialized subclass of the generalized {@link LandVehicle} class that represents an {@link Train}.
 */
public class Train extends LandVehicle {

    /**
     * This instantiates an empty {@link Train} object with default null values.
     */
    public Train() {
        super();
    }

    /**
     * This instantiates an {@link Train} object.
     * @param name the name of the vehicle
     * @param type the type of the vehicle
     * @param weightCap the weight capacity of the vehicle
     * @param vol the volume of the vehicle
     * @param cost the cost of the vehicle
     * @param speed the speed of the vehicle
     * @param memCount the number of members of the vehicle
     * @param mealCost the cost per member
     * @param crewSalary the salary of the crew
     * @param measurements the measurements of the vehicle
     * @param description the description of the vehicle
     * @param interestingFact the interesting fact of the vehicle
     * @param notes the notes of the vehicle
     */
    public Train(String name, String type, BigDecimal weightCap, BigDecimal vol, BigDecimal cost, BigDecimal speed, int memCount, int mealCost, int crewSalary, String measurements, String description, String interestingFact, String notes) {
        super(name, type, weightCap, vol, cost, speed, memCount, mealCost, crewSalary, measurements, description, interestingFact, notes);
    }
}
