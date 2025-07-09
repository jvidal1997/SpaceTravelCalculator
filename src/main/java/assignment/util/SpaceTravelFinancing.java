/**
 * This class is intended to perform financial calculations.
 * @author J. Vidal
 * 10.02.2024
 */
package assignment.util;

/**
 * This class is intended to perform financial calculations.
 */
public class SpaceTravelFinancing extends AbstractUtilityClass {
    /**
     * The rate of conversion from US dollars to Euros.
     */
    private static final double US_TO_EU_RATE = 0.895563;
    /**
     * The rate of conversion from Euros to US dollars.
     */
    private static final double EU_TO_US_RATE = 1.116544;

    /**
     * This is an explicit default constructor for a class of static methods.
     */
    private SpaceTravelFinancing() {}

    /**
     * Calculates the total salary of a crew member based on their hourly salary and the length of the trip.
     *
     * @param salary  the hourly salary of the crew member
     * @param hours   the length of the trip in hours
     * @return        the total salary of a single crew member
     */
    public static double SingleMemberSalary(double salary, double hours) {
        return salary * hours;
    }

    /**
     * Calculates the daily salary of a crew member based on their hourly salary and the number of work hours in a single day.
     * @param hourlySalary hourly salary
     * @param numOfPayHours number of work hours
     * @return daily salary
     */
    public static double SingleMemberDailyPay(double hourlySalary, double numOfPayHours) {
        return hourlySalary * numOfPayHours;
    }

    /**
     * Calculates the cost of food per day for a crew member.
     * @param costPerMeal the cost of food per meal
     * @param numOfMealsPerDay number of meals per day
     * @return the daily cost of food per crew member
     */
    public static double DailyFoodCost(double costPerMeal, double numOfMealsPerDay) {
        return costPerMeal * numOfMealsPerDay;
    }

    /**
     * Calculates the total salary paid to all crew members based on their hourly salary
     * @param hoursInADay work hours in a day
     * @param tripDurationInDays trip duration in days
     * @param hourlyEquitableSalaryPerMember the hourly salary of a single crew member
     * @param numOfMembers number of crew members
     * @return the total salary paid to all crew members
     */
    public static double TotalAnnualEquitableCrewSalary(double hoursInADay, double tripDurationInDays, double hourlyEquitableSalaryPerMember, double numOfMembers) {
        return hoursInADay * tripDurationInDays * hourlyEquitableSalaryPerMember * numOfMembers;
    }

    /**
     * Calculates the total cost of food for all crew members
     * @param mealsPerDay number of meals per day
     * @param tripDurationInDays trip duration in days
     * @param memberFoodCostPerMeal cost of food per meal
     * @param numOfMembers number of crew members
     * @return the total cost of food for all crew members
     */
    public static double TotalAnnualEquitableCrewFoodCosts(double mealsPerDay, double tripDurationInDays, double memberFoodCostPerMeal, double numOfMembers) {
        return mealsPerDay * tripDurationInDays * memberFoodCostPerMeal * numOfMembers;
    }

    /**
     * Calculates the total salary paid to all crew members based on their hourly salary,
     * the length of the trip, and the total number of crew members.
     *
     * @param salary  the hourly salary of a single crew member
     * @param hours   the length of the trip in hours
     * @param crewSize  the total number of crew members
     * @return        the total salary of all crew members
     */
    public static double TotalCrewSalary(double salary, double hours, int crewSize) {
        return (salary) * hours * crewSize;
    }

    /**
     * Converts a given amount of US dollars to Euros.
     *
     * @param USDollars  the amount of US dollars to be converted
     * @return          the equivalent amount in euros
     */
    public static double USDtoEU(double USDollars) {
        return USDollars * US_TO_EU_RATE;
    }

    /**
     * Converts a given amount of Euros to US Dollars.
     *
     * @param EUR  the amount of Euros to be converted
     * @return     the equivalent amount in US Dollars
     */
    public static double EUtoUSD(double EUR) {
        return EUR * EU_TO_US_RATE;
    }
}
