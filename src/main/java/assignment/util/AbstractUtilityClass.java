/**
 * This class contains the static methods for all the Utility Classes.
 * J. Vidal
 * 10.23.2024
 */
package assignment.util;

import assignment.data.PlanetaryConstants;
import assignment.trip.Trip;

/**
 * This class contains the static methods for all the Utility Classes.
 */
public class AbstractUtilityClass {
    /**
     * The hours in a day
     */
    private static double hoursInDay;
    /**
     * The days in a year
     */
    private static double daysInYear;
    /**
     * The gravitational constant
     */
    private static double gravitationalConstant;
    /**
     * The mass of the Sun
     */
    private static double massOfSun;
    /**
     * The conversion rate for pounds to kilograms
     */
    private static double poundsToKilograms;
    /**
     * The conversion rate for kilograms to pounds
     */
    private static double kilogramsToPounds;
    /**
     * The conversion rate for miles to kilometers
     */
    private static double milesToKilometers;
    /**
     * The conversion rate for kilometers to miles
     */
    private static double kilometersToMiles;

    /**
     * An explicit default constructor for a class of static methods.
     */
    AbstractUtilityClass() {}

    /**
     * Updates the constants for Utility Classes.
     */
    public static void updateConstants() {
        if (Trip.isPrecise()) {
            setHoursInDay(Double.parseDouble(PlanetaryConstants.getConstants().get("preciseHoursInDay")));
            setDaysInYear(Double.parseDouble(PlanetaryConstants.getConstants().get("preciseDaysInYear")));
            setGravitationalConstant(Double.parseDouble(PlanetaryConstants.getConstants().get("preciseGravitationalConstant")));
            setMassOfSun(Double.parseDouble(PlanetaryConstants.getConstants().get("preciseMassOfSun")));
            setPoundsToKilograms(Double.parseDouble(PlanetaryConstants.getConstants().get("precisePoundsToKilograms")));
            setKilogramsToPounds(Double.parseDouble(PlanetaryConstants.getConstants().get("preciseKilogramsToPounds")));
            setMilesToKilometers(Double.parseDouble(PlanetaryConstants.getConstants().get("preciseMilesToKilometers")));
            setKilometersToMiles(Double.parseDouble(PlanetaryConstants.getConstants().get("preciseKilometersToMiles")));
        } else {
            setHoursInDay(Double.parseDouble(PlanetaryConstants.getConstants().get("estimateHoursInDay")));
            setDaysInYear(Double.parseDouble(PlanetaryConstants.getConstants().get("estimateDaysInYear")));
            setGravitationalConstant(Double.parseDouble(PlanetaryConstants.getConstants().get("estimateGravitationalConstant")));
            setMassOfSun(Double.parseDouble(PlanetaryConstants.getConstants().get("estimateMassOfSun")));
            setPoundsToKilograms(Double.parseDouble(PlanetaryConstants.getConstants().get("estimatePoundsToKilograms")));
            setKilogramsToPounds(Double.parseDouble(PlanetaryConstants.getConstants().get("estimateKilogramsToPounds")));
            setMilesToKilometers(Double.parseDouble(PlanetaryConstants.getConstants().get("estimateMilesToKilometers")));
            setKilometersToMiles(Double.parseDouble(PlanetaryConstants.getConstants().get("estimateKilometersToMiles")));
        }
    }

    /**
     * Gets the hours in a day
     * @return (double) hoursInDay
     */
    public static double getHoursInDay() {
        return hoursInDay;
    }

    /**
     * Sets the hours in a day
     * @param hoursInDay (double) hoursInDay
     */
    private static void setHoursInDay(double hoursInDay) {
        AbstractUtilityClass.hoursInDay = hoursInDay;
    }

    /**
     * Gets the days in a year
     * @return (double) daysInYear
     */
    public static double getDaysInYear() {
        return daysInYear;
    }

    /**
     * Sets the days in a year
     * @param daysInYear (double) daysInYear
     */
    private static void setDaysInYear(double daysInYear) {
        AbstractUtilityClass.daysInYear = daysInYear;
    }

    /**
     * Gets the gravitational constant
     * @return (double) gravitationalConstant
     */
    public static double getGravitationalConstant() {
        return gravitationalConstant;
    }

    /**
     * Sets the gravitational constant
     * @param gravitationalConstant (double) gravitationalConstant
     */
    private static void setGravitationalConstant(double gravitationalConstant) {
        AbstractUtilityClass.gravitationalConstant = gravitationalConstant;
    }

    /**
     * Gets the mass of the Sun
     * @return (double) massOfSun
     */
    public static double getMassOfSun() {
        return massOfSun;
    }

    /**
     * Sets the mass of the Sun
     * @param massOfSun (double) massOfSun
     */
    private static void setMassOfSun(double massOfSun) {
        AbstractUtilityClass.massOfSun = massOfSun;
    }

    /**
     * Gets the conversion rate for pounds to kilograms
     * @return (double) poundsToKilograms
     */
    public static double getPoundsToKilograms() {
        return poundsToKilograms;
    }

    /**
     * Sets the conversion rate for pounds to kilograms
     * @param poundsToKilograms (double) poundsToKilograms
     */
    private static void setPoundsToKilograms(double poundsToKilograms) {
        AbstractUtilityClass.poundsToKilograms = poundsToKilograms;
    }

    /**
     * Gets the conversion rate for kilograms to pounds
     * @return (double) kilogramsToPounds
     */
    public static double getKilogramsToPounds() {
        return kilogramsToPounds;
    }

    /**
     * Sets the conversion rate for kilograms to pounds
     * @param kilogramsToPounds (double) kilogramsToPounds
     */
    private static void setKilogramsToPounds(double kilogramsToPounds) {
        AbstractUtilityClass.kilogramsToPounds = kilogramsToPounds;
    }

    /**
     * Gets the conversion rate for miles to kilometers
     * @return (double) milesToKilometers
     */
    public static double getMilesToKilometers() {
        return milesToKilometers;
    }

    /**
     * Sets the conversion rate for miles to kilometers*
     * @param milesToKilometers (double) milesToKilometers
     */
    private static void setMilesToKilometers(double milesToKilometers) {
        AbstractUtilityClass.milesToKilometers = milesToKilometers;
    }

    /**
     * Gets the conversion rate for kilometers to miles
     * @return (double) kilometersToMiles
     */
    public static double getKilometersToMiles() {
        return kilometersToMiles;
    }

    /**
     * Sets the conversion rate for kilometers to miles
     * @param kilometersToMiles (double) kilometersToMiles
     */
    private static void setKilometersToMiles(double kilometersToMiles) {
        AbstractUtilityClass.kilometersToMiles = kilometersToMiles;
    }
}
