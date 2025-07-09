/**
 * This class is intended to store an array of {@link PlanetaryBody} objects.
 * @author J. Vidal
 * 10.02.2024
 */
package assignment.data;

import assignment.planetai.PlanetaryBody;
import edu.ccri.assignment.planets.data.DataAccessElement;
import edu.ccri.assignment.planets.data.DataAccessOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is intended to store an array of {@link PlanetaryBody} objects
 */
public class PlanetList implements DataAccessOperations {
    /**
     * An array of {@link PlanetaryBody} objects
     */
    public final ArrayList<PlanetaryBody> PLANETS = new ArrayList<>();

    /**
     * This is an explicit default constructor for a class that stores an array of {@link PlanetaryBody} objects
     */
    public PlanetList() {}

    /**
     * This method searches for a planet in an array of {@link PlanetaryBody} objects
     * @param name - name to match
     * @return the PlanetaryBody object, or null if not found
     */
    public DataAccessElement findName(String name) {
        DataAccessElement found = null;
        for (PlanetaryBody planet : PLANETS) {
            if (planet.getName().equals(name)) {
                found = planet;
            }
        }
        return found;
    }

    /**
     * This method sorts the {@link PlanetaryBody} objects in the <i>PLANETS</i> array by name in alphabetical order
     */
    public void sortPlanets() {
        PLANETS.sort((o1, o2) -> o1.getPlanetaryName().compareTo(o2.getPlanetaryName()));
    }

    /**
     * This method returns a list of planet names
     * @return a list of planet names
     */
    public List<String> getNameList() {
        List<String> names = new ArrayList<>();
        for (PlanetaryBody planet: PLANETS) {
            names.add(planet.getPlanetaryName());
        }
        return names;
    }
}
