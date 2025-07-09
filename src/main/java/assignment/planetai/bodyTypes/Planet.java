/**
 * This class instantiates a {@link Planet} object that is a {@link PlanetaryBody}.
 * @author J. Vidal
 * 10.02.2024
 */
package assignment.planetai.bodyTypes;

import assignment.planetai.PlanetaryBody;

/**
 * This class is a subclass of the {@link PlanetaryBody} class.
 */
public class Planet extends PlanetaryBody {
    /**
     * This creates an empty {@link Planet} object.
     */
    public Planet(){
        super();
        setClassification("planet");
    }

    /**
     * This method instantiates a {@link Planet} object.
     * @param name the name of the planet
     * @param dia the diameter of the planet
     * @param weight the weight of the planet relative to Earth
     * @param dFromE the distance from the Sun of the planet
     * @param dFromS the distance from the Sun of the planet
     * @param oe the orbital eccentricity of the planet
     * @param al the albedo of the planet
     * @param dayLen the length of a day on the planet
     * @param yrLen the length of a year on the planet
     */
	public Planet(String name, double dia, double weight, double dFromE, double dFromS, double oe, double al, double dayLen, double yrLen) {
        super(name, "planet", dia, weight, dFromE, dFromS, oe, al, dayLen, yrLen);
    }

    /**
     * This method returns a string representation of the {@link Planet} object by calling the {@link PlanetaryBody#toString()} superclass method.
     * @return a string representation of the {@link Planet} object
     */
    public String toString() {
        return super.toString();
    }
}
