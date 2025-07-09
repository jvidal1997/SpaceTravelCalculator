/**
 * This class is intended to perform conversion calculations for the purpose of determining business metrics in travel to planetary bodies.
 *
 * @author J. Vidal
 * Created - 09.07.2024
 * Last updated - 10.02.2024
 */
package assignment.util;

import java.time.LocalDate;

/**
 *  This class is intended to perform conversion calculations.
 */
public class Metrics extends AbstractUtilityClass {
	
	/**
	 * This is an explicit default constructor for a class of static methods.
	 */
	private Metrics() {super();}
    // TIME CONVERSIONS

    /**
     * Converts hours to days
     * @param hours the number of hours
     * @return the number of days
     */
    public static double hoursToDay(double hours) {
        return hours / getHoursInDay();
    }

    /**
     * Converts days to years
     * @param days the number of days
     * @return the number of years
     */
    public static double daysToYear(double days) {
        return days / getDaysInYear();
    }

    /**
     * Converts hours to years
     * @param hours the number of hours
     * @return the number of years
     */
    public static double hoursToYears(double hours) {
        return (hours / getHoursInDay()) / getDaysInYear();
    }

    // GEOMETRIC CONVERSIONS

    /**
     * Calculates the diameter of a circle with the given radius
     * @param radius the radius of the circle
     * @return the diameter of the circle
     */
    public static double radiusToDiameter(double radius) {
        return radius * 2;
    }

    /**
     * Calculates the radius of a circle with the given diameter
     * @param diameter the diameter of the circle
     * @return the radius of the circle
     */
    public static double diameterToRadius(double diameter) {
        return diameter / 2;
    }

    // RELATIONAL CALCULATIONS

    /**
     * Calculates the relative weight of two objects on a common planetary body
     * @param weight1 the weight of the first object on the body
     * @param weight2 the weight of the second object on the body
     * @return the relative weight
     */
    public static double relativeWeight(double weight1, double weight2) {
        return weight1 * weight2;
    }

    /**
     * Calculates the relative distance of two objects from a common location
     * @param distance1FromLocationA the distance of the first object from the location
     * @param distance2FromLocationA the distance of the second object from the location
     * @return the relative distance
     */
    public static double relativeDistance(double distance1FromLocationA, double distance2FromLocationA) {
        return Math.abs(distance1FromLocationA - distance2FromLocationA);
    }

    // TIME CALCULATIONS

    /**
     * Calculates a date using a start date and a number of days.
     *
     * @param startDate the date to start with
     * @param durationInDays the number of days to add to the start date
     * @return the date that is the given number of days after the start date
     */
    public static LocalDate dateDelta(LocalDate startDate, double durationInDays) {
        return startDate.plusDays((long) durationInDays);
    }

    /**
     * Calculates the duration of travel in hours
     * @param distance the distance of travel
     * @param velocity the velocity of travel per hour
     * @return the duration of travel
     */
    public static double travelDurationHours(double distance, double velocity) {
        return distance / velocity;
    }

    /**
     * Calculates the duration of travel in days
     * @param distance the distance of travel
     * @param velocity the velocity of travel
     * @return the duration of travel
     */
    public static double travelDurationDays(double distance, double velocity) {
        return travelDurationHours(distance, velocity) / getHoursInDay();
    }

    /**
     * Calculates the duration of travel in years
     * @param distance the distance of travel
     * @param velocity the velocity of travel
     * @return the duration of travel
     */
    public static double travelDurationYears(double distance, double velocity) {
        return travelDurationDays(distance, velocity) / getDaysInYear();
    }
}
