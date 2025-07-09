/**
 * This subclass instantiates a {@link Moon} object that is a specialized {@link PlanetaryBody}.
 * @author J. Vidal
 * 10.02.2024
 */
package assignment.planetai.bodyTypes;

import assignment.planetai.PlanetaryBody;

/**
 * This class is a subclass of the {@link PlanetaryBody} class.
 */
public class Moon extends PlanetaryBody {
    /**
     *  This method instantiates an empty {@link Moon} object.
     */
    public Moon() {
        super();
        setClassification("moon");
    }

    /**
     * This method instantiates a {@link Moon} object.
     * @param name the name of the moon
     * @param dia the diameter of the moon
     * @param weight the weight of the moon relative to Earth
     * @param dFromE the distance from the Sun of the moon
     * @param dFromS the distance from the Sun of the moon
     * @param oe the orbital eccentricity of the moon
     * @param al the albedo of the moon
     * @param dayLen the length of a day on the moon
     * @param yrLen the length of a year on the moon
     */
    public Moon(String name, double dia, double weight, double dFromE, double dFromS, double oe, double al, double dayLen, double yrLen) {
        super(name, "moon", dia, weight, dFromE, dFromS, oe, al, dayLen, yrLen);
    }

    /**
     * This method returns a string representation of the {@link Moon} object by calling the {@link PlanetaryBody#toString()} superclass method.
     * @return a string representation of the {@link Moon} object
     */
    public String toString() {
        return super.toString();
    }
}
