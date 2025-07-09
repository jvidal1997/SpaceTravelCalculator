/**
 * This class is intended represent a transportation vehicle.
 *
 * @author J. Vidal
 * 09.07.2024
 */
package assignment.transportation;

import assignment.util.SpaceTravelFinancing;
import edu.ccri.assignment.planets.data.CrewExpenses;
import edu.ccri.assignment.planets.data.DataAccessElement;

import java.math.BigDecimal;

/**
 * This class represents an abstract transportation vehicle
 */
public abstract class TransportationVehicle implements DataAccessElement, CrewExpenses {
	/**
	 * The name of the vehicle
	 */
	String vehicleName;
	/**
	 * The classification of the vehicle
	 */
	String classification;
	/**
	 * The max weight of the vehicle
	 */
	BigDecimal maxWeight;
	/**
	 * The volume of the vehicle
	 */
	BigDecimal volume;
	/**
	 * The cost to build the vehicle
	 */
	BigDecimal buildCost;
	/**
	 * The max speed of the vehicle
	 */
	BigDecimal maxSpeed;
	/**
	 * The total number of crew members on the vehicle
	 */
	int numOfMembers;
	/**
	 * The cost of a meal per crew member
	 */
	int mealPerMemberCost;
	/**
	 * The hourly salary per crew member
	 */
	int crewSalaryPerHr;
	/**
	 * The VEHICLES measurements
	 */
	String measurements;
	/**
	 * The VEHICLES description
	 */
	String description;
	/**
	 * An interesting fact about the VEHICLES
	 */
	String interestingFact;
	/**
	 * Notes about the vehicle
	 */
	String notes;
	/**
	 * The vehicle's drag coefficient *
	 */
	double dragCoefficient;
	/**
	 * The number of meals served per day to each member
	 */
	double numOfMealsPerDay;
	/**
	 * The work hours each member is paid per day
	 */
	double payHoursPerDay;

	/**
	 * Instantiates an empty {@link TransportationVehicle} object. *
	 */
	public TransportationVehicle() {}

	/**
	 * Instantiates a {@link TransportationVehicle} object.
	 *
	 * @param name the vehicle's name
	 * @param type the vehicle's classification
	 * @param weightCap the vehicle's weight capacity
	 * @param vol the vehicle's volume
	 * @param cost the vehicle's build cost
	 * @param speed the vehicle's max speed
	 * @param memCount the vehicle's total number of members
	 * @param mealCost the vehicle's cost per meal per member
	 * @param crewSalary the vehicle's hourly salary per member
	 * @param measurements the vehicle's measurements
	 * @param description the vehicle's description
	 * @param interestingFact the vehicle's interesting fact
	 * @param notes the vehicle's notes
	 */
	public TransportationVehicle(String name, String type, BigDecimal weightCap, BigDecimal vol, BigDecimal cost, BigDecimal speed, int memCount, int mealCost, int crewSalary, String measurements, String description, String interestingFact, String notes) {
		setVehicleName(name);
		setClassification(type);
		setMaxWeight(weightCap);
		setVolume(vol);
		setBuildCost(cost);
		setMaxSpeed(speed);
		setNumOfMembers(memCount);
		setMealPerMemberCost(mealCost);
		setCrewSalaryPerHr(crewSalary);
		setMeasurements(measurements);
		setDescription(description);
		setInterestingFact(interestingFact);
		setNotes(notes);
	}

	// SETTERS

	/**
	 * Sets the vehicle's name.
	 * @param name the name to assign
	 */
	public void setVehicleName(String name) { this.vehicleName = name; }

	/**
	 * Sets the vehicle's classification.
	 * @param type the classification to assign
	 */
	public void setClassification(String type) { this.classification = type; }

	/**
	 * Sets the vehicle's weight capacity.
	 * @param weightCap the max weight to assign
	 */
	public void setMaxWeight(BigDecimal weightCap) { this.maxWeight = weightCap; }

	/**
	 * Sets the vehicle's volume.
	 * @param vol the volume to assign
	 */
	public void setVolume(BigDecimal vol) { this.volume = vol; }

	/**
	 * Sets the vehicle's build cost.
	 * @param cost the build cost to assign
	 */
	public void setBuildCost(BigDecimal cost) { this.buildCost = cost; }

	/**
	 * Sets the vehicle's max speed.
	 * @param speed the max speed to assign
	 */
	public void setMaxSpeed(BigDecimal speed) { this.maxSpeed = speed; }

	/**
	 * Sets the vehicle's total number of members.
	 * @param memCount the number of members to assign
	 */
	public void setNumOfMembers(int memCount) { this.numOfMembers = memCount; }

	/**
	 * Sets the vehicle's meal-per-member cost.
	 * @param mealCost the cost per meal to assign
	 */
	public void setMealPerMemberCost(int mealCost) { this.mealPerMemberCost = mealCost; }

	/**
	 * Sets the vehicle's hourly salary per crew member.
	 * @param crewSalary the hourly salary to assign
	 */
	public void setCrewSalaryPerHr(int crewSalary) { this.crewSalaryPerHr = crewSalary; }

	/**
	 * Sets the vehicle's measurements.
	 * @param measurements the measurements to assign
	 */
	public void setMeasurements(String measurements) { this.measurements = measurements; }

	/**
	 * Sets the vehicle's description.
	 * @param description the description to assign
	 */
	public void setDescription(String description) { this.description = description; }

	/**
	 * Sets the vehicle's interesting fact.
	 * @param interestingFact the interesting fact to assign
	 */
	public void setInterestingFact(String interestingFact) { this.interestingFact = interestingFact; }

	/**
	 * Sets the vehicle's notes.
	 * @param notes the notes to assign
	 */
	public void setNotes(String notes) { this.notes = notes; }

	/**
	 * Sets the vehicle's drag coefficient.*
	 * @param dragCoefficient the drag coefficient to assign
	 */
	protected void setDragCoefficient(double dragCoefficient) { this.dragCoefficient = dragCoefficient; }

	/**
	 * Sets the number of meals served per day to each member.
	 * @param numOfMealsPerDay the number of meals to assign
	 */
	protected void setNumOfMealsPerDay(double numOfMealsPerDay) { this.numOfMealsPerDay = numOfMealsPerDay; }

	/**
	 * Sets the number of work hours each crew member is paid for per day.*
	 * @param payHoursPerDay the number of hours to assign
	 */
	protected void setPayHoursPerDay(double payHoursPerDay) { this.payHoursPerDay = payHoursPerDay; }

	// GETTERS

	/**
	 * Gets the vehicle's name.
	 * @return (String) vehicleName
	 */
	public String getVehicleName() { return vehicleName; }

	/**
	 * Gets the vehicle's classification.
	 * @return (String) classification
	 */
	public String getClassification() { return classification; }

	/**
	 * Gets the vehicle's weight capacity.
	 * @return (double) maxWeight
	 */
	public BigDecimal getMaxWeight() { return maxWeight; }

	/**
	 * Gets the vehicle's volume.
	 * @return (double) volume
	 */
	public BigDecimal getVolume() { return volume; }

	/**
	 * Gets the vehicle's cost to build.
	 * @return (long) buildCost
	 */
	public BigDecimal getBuildCost() { return buildCost; }

	/**
	 * Gets the vehicle's max speed.
	 * @return (double) maxSpeed
	 */
	public BigDecimal getMaxSpeed() { return maxSpeed; }

	/**
	 * Gets the vehicle's total number of members.
	 * @return (int) numOfMembers
	 */
	public int getNumOfMembers() { return numOfMembers; }

	/**
	 * Gets the vehicle's meal-per-member cost.
	 * @return (int) mealPerMemberCost
	 */
	public int getMealPerMemberCost() { return mealPerMemberCost; }

	/**
	 *  Gets the vehicle's hourly salary per crew member.
	 * @return (int) crewSalaryPerHr
	 */
	public int getCrewSalaryPerHr() { return crewSalaryPerHr; }

	/**
	 * Gets the vehicle's measurements.
	 * @return (String) measurements
	 */
	public String getMeasurements() { return measurements; }

	/**
	 * Gets the vehicle's description.
	 * @return (String) description
	 */
	public String getDescription() { return description; }

	/**
	 * Gets the vehicle's interesting fact.
	 * @return (String) interestingFact
	 */
	public String getInterestingFact() { return interestingFact; }

	/**
	 * Gets the vehicle's notes.
	 * @return (String) notes
	 */
	public String getNotes() { return notes; }

	/**
	 * Gets the vehicle's drag coefficient.*
	 * @return (double) dragCoefficient
	 */
	public double getDragCoefficient() { return this.dragCoefficient; }

	/**
	 * Gets the number of meals served per day to each member.
	 * @return (double) numOfMealsPerDay
	 */
	public double getNumOfMealsPerDay() { return this.numOfMealsPerDay; }

	/**
	 * Gets the number of work hours each crew member is paid for per day.*
	 * @return (double) payHoursPerDay
	 */
	public double getPayHoursPerDay() { return this.payHoursPerDay; }

	// METHODS

	/**
	 * Returns the calculated daily food cost per crew member.*
	 * @return (double) daily food cost per crew member
	 */
	public double getDailyFoodCostPerCrewMember() {
		return SpaceTravelFinancing.DailyFoodCost(this.getMealPerMemberCost(), this.getNumOfMealsPerDay());
	}

	/**
	 * Returns the calculated daily salary per crew member.*
	 * @return (double) daily salary per crew member
	 */
	public double getDailySalaryPerCrewMember() {
		return SpaceTravelFinancing.SingleMemberDailyPay(this.getCrewSalaryPerHr(), this.getPayHoursPerDay());
	}

	/**
	 * Returns the name of the {@link TransportationVehicle} object*
	 * @return (String) name
	 */
	public String getName() {
		return String.format("%s", this.getVehicleName());
	}

	/**
	 * Returns a string representation of the <b>TransportationVehicle</b> object, containing the:
	 * <ul>
	 *      <li>name</li>
	 *      <li>classification</li>
	 *      <li>weight capacity</li>
	 *      <li>volume</li>
	 *      <li>build cost</li>
	 *      <li>max speed</li>
	 *      <li>total number of members</li>
	 *      <li>meal-per-member cost</li>
	 *      <li>hourly salary per crew member</li>
	 *      <li>measurements</li>
	 *      <li>description</li>
	 *      <li>interesting fact</li>
	 *      <li>notes</li>
	 *      <li>numOfMealsPerDay</li>
	 *      <li>payHoursPerDay</li>
	 * </ul>
	 * @return a string representation of the {@link TransportationVehicle} object.
	 */
	@Override
	public String toString() {
		return String.format("%s | %s | %s | %s | %s | %s | %d | %d | %d", this.vehicleName, this.classification, this.maxWeight.toString(), this.volume.toString(), this.buildCost.toString().contains("\\w+\\.\\w+") ? this.buildCost.toString() : String.valueOf( this.buildCost.longValueExact()), this.maxSpeed.toString(), this.numOfMembers, this.mealPerMemberCost, this.crewSalaryPerHr);
	}
}
