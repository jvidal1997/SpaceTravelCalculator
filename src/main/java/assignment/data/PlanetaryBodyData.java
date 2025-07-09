/**
 * This class is intended to manage a list of {@link PlanetaryBody} objects using the {@link PlanetList} object.
 *
 * @author J. Vidal
 * 09.07.2024
 */
package assignment.data;

import assignment.planetai.PlanetaryBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class manages a {@link PlanetList} object that contains a list of {@link PlanetaryBody} objects.
 */
public class PlanetaryBodyData {
	/**
	 * A logger for testing static methods
	 */
	private static final Logger log = LogManager.getLogger(PlanetaryBodyData.class.getName());
	/**
	 * A {@link PlanetList} object for storing a static array of PlanetaryBody objects
	 */
	private static final PlanetList PLANET_LIST = new PlanetList();

	/**
	 * This is an explicit default constructor for a class of static methods.
	 */
	public PlanetaryBodyData() {}

	/**
	 * This method adds the provided {@link PlanetaryBody} object to the <i>PLANETS</i> array of the {@link PlanetList} object <i>PLANET_LIST</i>.
	 * @param planet the {@link PlanetaryBody} object to add
	 */
	public static void addPlanet(PlanetaryBody planet) {
		PLANET_LIST.PLANETS.add(planet);
		log.debug(PLANET_LIST.PLANETS.getLast().toString());
	}

	/**
	 * Compiles an array of strings representing Planet names from a list of {@link PlanetaryBody} objects
	 * @return an array of strings, representing planet names
	 */
	public static String[] getPlanetNames() {
		return PLANET_LIST.getNameList().toArray(new String[0]);
	}

	/**
	 * Searches for a planet in an array of {@link PlanetaryBody} objects
	 * @param name the name of the planet to search for
	 * @return the PlanetaryBody object, or null if not found
	 */
	public static PlanetaryBody getPlanet(String name) {
		for (PlanetaryBody planet: PLANET_LIST.PLANETS) {
			if (planet.getPlanetaryName().equalsIgnoreCase(name)) {
				return planet;
			}
		}
		return null;
	}

	/**
	 * Removes all {@link PlanetaryBody} objects from the <i>PLANETS</i> array of the {@link PlanetList} object <i>PLANET_LIST</i>.
	 */
	public static void clearPlanets() {
		PLANET_LIST.PLANETS.clear();
	}

	/**
	 * Sorts the <i>PLANETS</i> array of the {@link PlanetList} object <i>PLANET_LIST</i>.
	 */
	public static void sortPlanets() {
		PLANET_LIST.sortPlanets();
	}

	/**
	 * Returns a string representation of the {@link PlanetaryBodyData} object.
	 * @return a string representation of the array of {@link PlanetaryBody} objects
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("\n");
		for (PlanetaryBody planet : PLANET_LIST.PLANETS) {
			string.append(planet.toString()).append("\n");
		}
		return string.toString();
	}
}
