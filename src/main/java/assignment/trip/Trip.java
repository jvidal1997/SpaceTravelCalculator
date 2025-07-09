/**
 * This class is intended to represent a trip between two PLANETS.
 *
 * @author J. Vidal
 * 09.07.2024
 */
package assignment.trip;

import assignment.planetai.PlanetaryBody;
import assignment.transportation.TransportationVehicle;
import assignment.util.Metrics;
import assignment.util.ScientificCalc;
import assignment.util.SpaceTravelFinancing;

import java.time.LocalDate;

/**
 * This class represents a trip between two PLANETS.
 * <br><br>
 * Each trip contains:
 * <ul>
 *     <li>the starting planet</li>
 *     <li>the destination planet</li>
 *     <li>the vehicle</li>
 *     <li>the distance of the trip</li>
 *     <li>the speed of the vehicle</li>
 *     <li>the amount of time needed for the trip</li>
 *     <li>the cost of paying each crew member per day</li>
 *     <li>the cost of feeding each member of the crew per day</li>
 *     <li>the total cost of paying the entire crew</li>
 *     <li>the total cost of feeding the entire crew</li>
 *     <li>the total gross income of the entire crew (pay and food costs)</li>
 * </ul>
 */
public class Trip {
    // Attributes
    /**
     * The starting planetary body of the trip
     */
    PlanetaryBody startingPlanet;
    /**
     * The destination planetary body of the trip
     */
    PlanetaryBody destinationPlanet;
    /**
     * The vehicle used for the trip
     */
    TransportationVehicle vehicle;
    /**
     * The total distance for the trip
     */
    double tripDistance;
    /**
     * The max speed of the vehicle used for the trip
     */
    double vehicleSpeed;
    /**
     * Gravity Assist Velocity
     */
    double GAV;
    /**
     * Gravity Assist Velocity with Drag Coefficient
     */
    double GAV_WITH_DRAG;
    /**
     * Transportation Vehicle Velocity with Drag Coefficient
     */
    double TVV_WITH_DRAG;
    /**
     * The amount of time needed for the trip
     */
    double travelDurationInHours;
    /**
     * The cost of paying each crew member per day
     */
    double dailySalaryPerCrewMember;
    /**
     * The cost of feeding each crew member per day
     */
    double dailyFoodCostPerMember;
    /**
     * The total cost of paying the entire crew
     */
    double totalAnnualEquitableCrewSalary;
    /**
     * The total cost of feeding the entire crew
     */
    double totalAnnualEquitableFoodCosts;
    /**
     * The total gross income of the entire crew (pay and food costs)
     */
    double totalAnnualCrewGrossIncome;
    /**
     * The date of departure
     */
    LocalDate departureDate;
    /**
     * The date of arrival
     */
    LocalDate arrivalDate;
    /**
     * Determines if the output should be precise or not
     */
    private static boolean precise = false;

    // Constructors
    /**
     * Instantiates a <b>Trip</b> object using the given parameters.<br><br>
     * This constructor also uses the <b>ScientificCalc</b> class to determine the travel duration, as well as the <b>SpaceTravelFinancing</b> class to determine the total amount of money paid to each crew member and the total amount of money paid to the entire crew.
     *
     * @param startingPlanet - the starting planet
     * @param destinationPlanet - the destination planet
     * @param vehicle - the vehicle
     * @param tripDistance - the distance of the trip
     * @param vehicleSpeed - the speed of the vehicle
     */
    public Trip(PlanetaryBody startingPlanet, PlanetaryBody destinationPlanet, TransportationVehicle vehicle, double tripDistance, double vehicleSpeed) {
        this.startingPlanet = startingPlanet;
        this.destinationPlanet = destinationPlanet;
        this.vehicle = vehicle;
        this.tripDistance = Metrics.relativeDistance(startingPlanet.getDistanceFromSun(), destinationPlanet.getDistanceFromSun());
        this.vehicleSpeed = ScientificCalc.gravityAssistWithDrag(startingPlanet, vehicle);
        this.travelDurationInHours = Metrics.travelDurationHours(tripDistance, vehicleSpeed);
        this.dailySalaryPerCrewMember = this.vehicle.getDailySalaryPerCrewMember();
        this.dailyFoodCostPerMember = this.vehicle.getDailyFoodCostPerCrewMember();
        this.totalAnnualEquitableCrewSalary = SpaceTravelFinancing.TotalAnnualEquitableCrewSalary(vehicle.getPayHoursPerDay(), Metrics.hoursToDay(this.travelDurationInHours), this.vehicle.getCrewSalaryPerHr(), this.vehicle.getNumOfMembers());
        this.totalAnnualEquitableFoodCosts = SpaceTravelFinancing.TotalAnnualEquitableCrewFoodCosts(this.vehicle.getNumOfMealsPerDay(), Metrics.hoursToDay(this.travelDurationInHours), this.vehicle.getMealPerMemberCost(), this.vehicle.getNumOfMembers());
        this.totalAnnualCrewGrossIncome = this.totalAnnualEquitableCrewSalary + this.totalAnnualEquitableFoodCosts;
    }

    /**
     * Instantiates a <b>Trip</b> object using the given parameters.<br><br>
     * This constructor also uses the <b>ScientificCalc</b> class to determine the travel duration, as well as the <b>SpaceTravelFinancing</b> class to determine the total amount of money paid to each crew member and the total amount of money paid to the entire crew.
     *
     * @param startingPlanet - the starting planet
     * @param destinationPlanet - the destination planet
     * @param vehicle - the vehicle
     * @param tripDistance - the distance of the trip
     * @param vehicleSpeed - the speed of the vehicle
     * @param departDate - the date of departure
     */
    public Trip(PlanetaryBody startingPlanet, PlanetaryBody destinationPlanet, TransportationVehicle vehicle, double tripDistance, double vehicleSpeed, LocalDate departDate) {
        this.startingPlanet = startingPlanet;
        this.destinationPlanet = destinationPlanet;
        this.vehicle = vehicle;
        this.tripDistance = Metrics.relativeDistance(startingPlanet.getDistanceFromSun(), destinationPlanet.getDistanceFromSun());
        this.vehicleSpeed = vehicle.getMaxSpeed().doubleValue();
        this.GAV = ScientificCalc.gravityAssistVelocity(startingPlanet.getOrbitalVelocity(), vehicle.getMaxSpeed().doubleValue());
        this.GAV_WITH_DRAG = ScientificCalc.gravityAssistWithDrag(startingPlanet, vehicle);
        this.TVV_WITH_DRAG = ScientificCalc.TransportationVehicleVelocityWithDrag(vehicle);
        this.travelDurationInHours = Metrics.travelDurationHours(tripDistance, vehicleSpeed);
        this.dailySalaryPerCrewMember = this.vehicle.getDailySalaryPerCrewMember();
        this.dailyFoodCostPerMember = this.vehicle.getDailyFoodCostPerCrewMember();
        this.totalAnnualEquitableCrewSalary = SpaceTravelFinancing.TotalAnnualEquitableCrewSalary(vehicle.getPayHoursPerDay(), Metrics.hoursToDay(this.travelDurationInHours), this.vehicle.getCrewSalaryPerHr(), this.vehicle.getNumOfMembers());
        this.totalAnnualEquitableFoodCosts = SpaceTravelFinancing.TotalAnnualEquitableCrewFoodCosts(this.vehicle.getNumOfMealsPerDay(), Metrics.hoursToDay(this.travelDurationInHours), this.vehicle.getMealPerMemberCost(), this.vehicle.getNumOfMembers());
        this.totalAnnualCrewGrossIncome = this.totalAnnualEquitableCrewSalary + this.totalAnnualEquitableFoodCosts;
        this.departureDate = departDate;
        this.arrivalDate = Metrics.dateDelta(departDate, Metrics.travelDurationDays(tripDistance, vehicleSpeed));
    }

    // Getters
    /**
     * Returns the name of the starting planet.
     *
     * @return the name of the starting planet.
     */
    public String getStartingPlanet() {
        return startingPlanet.getPlanetaryName();
    }

    /**
     * Returns the name of the destination planet.
     *
     * @return the name of the destination planet.
     */
    public String getDestinationPlanet() {
        return destinationPlanet.getPlanetaryName();
    }

    /**
     * Returns the name of the vehicle used for the trip.
     *
     * @return the name of the vehicle.
     */
    public String getVehicleName() {
        return vehicle.getVehicleName();
    }

    /**
     * Returns the total distance of the trip.
     *
     * @return the total distance of the trip
     */
    public double getTripDistance() {
        return tripDistance;
    }

    /**
     * Returns the speed of the vehicle used for the trip.
     *
     * @return the speed of the vehicle
     */
    public double getVehicleSpeed() {
        return vehicleSpeed;
    }

    /**
     * Returns the duration of travel.
     *
     * @return the duration of travel in hours
     */
    public double getTravelDurationInHours() {
        return travelDurationInHours;
    }

    /**
     * Returns the cost of paying each crew member per day.
     * @return the cost of paying each crew member per day
     */
    public double getDailySalaryPerCrewMember() {
        return this.dailySalaryPerCrewMember;
    }

    /**
     * Returns the cost of feeding each crew member per day
     * @return the cost of feeding each crew member per day
     */
    public double getDailyFoodCostPerMember() {
        return this.dailyFoodCostPerMember;
    }

    /**
     * Returns the total cost of paying the entire crew
     * @return the total cost of paying the entire crew
     */
    public double getTotalAnnualEquitableCrewSalary() {
        return totalAnnualEquitableCrewSalary;
    }

    /**
     * Returns the total cost of feeding the entire crew
     * @return the total cost of feeding the entire crew
     */
    public double getTotalAnnualCrewGrossIncome() {
        return totalAnnualCrewGrossIncome;
    }

    /**
     * Returns the total cost of feeding the entire crew
     * @return the total cost of feeding the entire crew
     */
    public double getTotalAnnualEquitableFoodCosts() {
        return totalAnnualEquitableFoodCosts;
    }

    /**
     * Returns the vehicle used for the trip
     * @return the vehicle
     */
    public TransportationVehicle getVehicle() {
        return vehicle;
    }

    /**
     * Returns the GAV
     * @return the GAV
     */
    public double getGAV() {
        return GAV;
    }

    /**
     * Returns the GAV with drag
     * @return the GAV
     */
    public double getGAV_WITH_DRAG() {
        return GAV_WITH_DRAG;
    }

    /**
     * Returns the TVV with drag
     * @return the TVV
     */
    public double getTVV_WITH_DRAG() {
        return TVV_WITH_DRAG;
    }

    /**
     * Returns the departure date of the trip
     * @return the departure date
     */
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    /**
     * Returns the arrival date of the trip
     * @return the arrival date
     */
    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the precise flag to true
     * @param isPrecise the precise flag
     */
    public static void setPrecise( boolean isPrecise ) {
        precise = isPrecise;
    }

    /**
     * Returns the precise flag
     * @return the precise flag
     */
    public static boolean isPrecise() {
        return precise;
    }

    // Methods
    /**
     * Returns a string representation of the <b>Trip</b> object, containing the:
     * <ul>
     *      <li>starting planet name</li>
     *      <li>destination planet name</li>
     *      <li>vehicle name</li>
     *      <li>trip distance</li>
     *      <li>vehicle speed</li>
     *      <li>travel duration</li>
     *      <li>cost to pay each crew member</li>
     *      <li>cost to feed each crew member</li>
     *      <li>total pay for entire crew</li>
     *      <li>total food cost for entire crew</li>
     *      <li>total gross income for entire crew</li>
     * </ul>
     *
     * @return a string representation of the <b>Trip</b> object.
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", this.getStartingPlanet(), this.getDestinationPlanet(), this.getVehicleName(), this.tripDistance, this.vehicleSpeed, this.travelDurationInHours, this.dailySalaryPerCrewMember, this.dailyFoodCostPerMember, this.totalAnnualEquitableCrewSalary, this.totalAnnualEquitableFoodCosts, this.totalAnnualCrewGrossIncome);
    }
}
