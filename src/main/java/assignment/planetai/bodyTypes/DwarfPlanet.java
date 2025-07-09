/**
 * This class instantiates a {@link DwarfPlanet} object that is a {@link PlanetaryBody}.
 * @author J. Vidal
 * 10.02.2024
 */
package assignment.planetai.bodyTypes;

import assignment.planetai.PlanetaryBody;

/**
 * This class is a subclass of the {@link PlanetaryBody} class.
 */
public class DwarfPlanet extends PlanetaryBody {
    /**
     * This creates an empty instance of the {@link DwarfPlanet} class.
     */
    public DwarfPlanet() {
        super();
        setClassification("dwarf planet");
    }

    /**
     * This method instantiates a {@link DwarfPlanet} object.
     * @param name the name of the dwarf planet
     * @param dia the diameter of the dwarf planet
     * @param weight the weight of the dwarf planet relative to Earth
     * @param dFromE the distance from the Sun of the dwarf planet
     * @param dFromS the distance from the Sun of the dwarf planet
     * @param oe the orbital eccentricity of the dwarf planet
     * @param al the albedo of the dwarf planet
     * @param dayLen the length of a day on the dwarf planet
     * @param yrLen the length of a year on the dwarf planet
     */
    public DwarfPlanet(String name, double dia, double weight, double dFromE, double dFromS, double oe, double al, double dayLen, double yrLen) {
        super(name, "dwarf planet", dia, weight, dFromE, dFromS, oe, al, dayLen, yrLen);
    }

    /**
     * This method returns a string representation of the {@link DwarfPlanet} object by calling the {@link PlanetaryBody#toString()} superclass method.
     * @return a string representation of the {@link DwarfPlanet} object
     */
    public String toString() {
        return super.toString();
    }
}