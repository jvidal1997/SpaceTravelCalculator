/**
 * This class is intended to perform scientific calculations.
 *
 * @author J. Vidal
 * 09.07.2024
 */
package assignment.util;

import assignment.planetai.PlanetaryBody;
import assignment.transportation.TransportationVehicle;

import java.security.InvalidParameterException;

/**
 * This class is intended to perform scientific calculations.<br>
 */
public final class ScientificCalc extends AbstractUtilityClass {

    /**
     * This is an explicit default constructor for a class of static methods.
     */
    private ScientificCalc() {}

    /**
     * Calculates the dragCoefficient of a planetary body using its classification,
     * albedo, and orbital eccentricity.
     *
     * @param name the name of the planetary body
     * @param classification the planetary body type ( Planet, Dwarf, or Moon )
     * @param Albedo the albedo of the planetary body
     * @param OrbitalEcc the orbital eccentricity of the planetary body
     * 
     * @return the calculated drag coefficient
     * @throws InvalidParameterException if classification is invalid
     */
    public static double dragCoefficient(String name, String classification, double Albedo, double OrbitalEcc) throws InvalidParameterException {
        return switch (classification.toLowerCase()) {
            case "planet" -> 0.1 + (Albedo * OrbitalEcc);
            case "dwarf planet" ->  0.35 + (Albedo * OrbitalEcc);
            case "moon" -> 0.75 + (Albedo * OrbitalEcc);
            default -> throw new InvalidParameterException(String.format("%s, %s: Classification validation failed.", name, classification));
        };
    }

    /**
     * Calculates the orbital velocity of a planetary body.
     *
     * @param dFromS the distance of the planetary body from the sun
     * @param yearLength the length of the planetary body's year in days
     * @return the orbital velocity
     */
    public static double orbitalVelocity(double dFromS, double yearLength) {
        return ( 3.6 * Math.sqrt((2 * Math.PI * dFromS * 1000) / yearLength * 86400) );
    }

    /**
     * Calculates the velocity accounting for gravity assist.
     *
     * @param ov the orbital velocity of the planetary body
     * @param velocity the velocity of the spacecraft
     * @return the velocity after accounting for gravity assist
     */
    public static double gravityAssistVelocity(double ov, double velocity) {
        return (2 * ov) + velocity;
    }

    /**
     * Calculates the velocity accounting for gravity assist, taking into account the drag coefficient of the planetary body.
     *
     * @param body the planetary body
     * @param vehicle the spacecraft
     * @return the velocity accounting for gravity assist
     */
    public static double gravityAssistWithDrag(PlanetaryBody body, TransportationVehicle vehicle) {
        return gravityAssistVelocity(body.getOrbitalVelocity(), vehicle.getMaxSpeed().doubleValue()) - body.getDragCoefficient();
    }

    /**
     * Calculates the velocity taking into account the drag coefficient of the vehicle.
     *
     * @param vehicle the spacecraft
     * @return the velocity accounting for the drag coefficient
     */
    public static double TransportationVehicleVelocityWithDrag(TransportationVehicle vehicle) {
        return vehicle.getMaxSpeed().doubleValue() - vehicle.getDragCoefficient();
    }
}
