/**
 * This is a factory class that creates concrete {@link PlanetaryBody} objects based on type.
 * @author J. Vidal
 * 10.13.2024
 */
package assignment.factories;

import assignment.planetai.PlanetaryBody;
import assignment.planetai.bodyTypes.DwarfPlanet;
import assignment.planetai.bodyTypes.Moon;
import assignment.planetai.bodyTypes.Planet;

/**
 * This is a factory class that creates concrete {@link PlanetaryBody} objects based on type.
 */
public class PlanetFactory {

    /**
     * This is an empty constructor for a {@link PlanetFactory} factory class.
     */
    private PlanetFactory(){
        // do nothing
    }

    /**
     * This method creates a {@link PlanetaryBody} object based on the provided type.
     * @param type the type of the {@link PlanetaryBody} object
     * @return the created {@link PlanetaryBody} object
     */
    public static PlanetaryBody create(String type) {
        return switch (type.toLowerCase()) {
            case "dwarf planet" -> new DwarfPlanet();
            case "moon" -> new Moon();
            case "planet" -> new Planet();
            default -> throw new IllegalArgumentException("Invalid body type: " + type);
        };
    }
}
