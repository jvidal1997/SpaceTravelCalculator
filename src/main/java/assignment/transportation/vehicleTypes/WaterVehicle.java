/**
 * This class is a generalized subclass of the abstract {@link TransportationVehicle} class that represents an {@link WaterVehicle}.
 * @author J. Vidal
 * 10.02.2024
 */
package assignment.transportation.vehicleTypes;

import assignment.transportation.TransportationVehicle;

import java.math.BigDecimal;

/**
 * This class is a generalized subclass of the abstract {@link TransportationVehicle} class that represents an {@link WaterVehicle}.
 */

public class WaterVehicle extends TransportationVehicle {
    /**
     * This instantiates an empty {@link WaterVehicle} object with default null values.
     */
    public WaterVehicle() {
        super();
        setClassification("water");
        this.setNumOfMealsPerDay(8);
        this.setPayHoursPerDay(16);
        this.setDragCoefficient(0.0744);
    }

    /**
     * This instantiates an {@link WaterVehicle} object.
     * @param vehicleName the name of the vehicle
     * @param classification the classification of the vehicle
     * @param maxWeight the max weight of the vehicle
     * @param volume the volume of the vehicle
     * @param buildCost the build cost of the vehicle
     * @param maxSpeed the max speed of the vehicle
     * @param numOfMembers the number of members in the vehicle
     * @param mealPerMemberCost the cost per member
     * @param crewSalaryPerHr the hourly salary per crew member
     * @param measurements the measurements of the vehicle
     * @param description the description of the vehicle
     * @param interestingFact the interesting fact of the vehicle
     * @param notes the notes of the vehicle
     */
    public WaterVehicle(String vehicleName, String classification, BigDecimal maxWeight, BigDecimal volume, BigDecimal buildCost, BigDecimal maxSpeed, int numOfMembers, int mealPerMemberCost, int crewSalaryPerHr, String measurements, String description, String interestingFact, String notes) {
        super(vehicleName, classification, maxWeight, volume, buildCost, maxSpeed, numOfMembers, mealPerMemberCost, crewSalaryPerHr, measurements, description, interestingFact, notes);
        this.setNumOfMealsPerDay(8);
        this.setPayHoursPerDay(16);
        this.setDragCoefficient(0.0744);
    }
}