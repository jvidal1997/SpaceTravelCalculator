/**
 * This class is intended to manage the user input dialog.
 * @author J. Vidal
 * 09.07.2024
 */
package assignment.test.util;

import assignment.data.PlanetaryBodyData;
import assignment.data.TransportationVehicleData;
import assignment.data.TripData;
import assignment.planetai.PlanetaryBody;
import assignment.transportation.TransportationVehicle;
import assignment.trip.Trip;
import assignment.util.Metrics;
import assignment.util.ScientificCalc;
import edu.ccri.assignment.planets.test.dialog.PlanetaryDialog;

/**
 * This class is intended to manage the user input dialog.
 */
public class UIHandler {
	/**
	 * This is an explicit default constructor for a class of static methods.
	 */
	private UIHandler() {
		
	}

    /**
     * Initializes a PlanetaryDialog object with default settings.
     * @param dialog the PlanetaryDialog object to be initialized
     */
    public static void initialize(PlanetaryDialog dialog) {
        dialog.setUseTransporationVehicle();
        dialog.setUseStartingPlanet();
        dialog.setUseDestinationPlanet();
    }

    /**
     * Gets user input from a multi-edit dialog for a trip from a source planet to a destination planet using a transportation vehicle.
     * @param dialog the PlanetaryDialog object to prompt the user with
     */
    public static void getInput(PlanetaryDialog dialog) {
        dialog.showMultiEditDialog(PlanetaryBodyData.getPlanetNames(), TransportationVehicleData.getVehicleNames());
    }

    /**
     * Adds a trip to the itinerary, given the user input provided in the dialog.
     * The trip is created by converting the input to objects and performing calculations,
     * then added to the list of trips.
     * @param dialog the PlanetaryDialog object containing the user input
     */
    public static void addTripToItinerary(PlanetaryDialog dialog) {
        // Convert input to objects
        TransportationVehicle vehicle = TransportationVehicleData.getVehicle(dialog.getTransportationVechicleName());
        PlanetaryBody startingPlanet = PlanetaryBodyData.getPlanet(dialog.getStartingPlanetName());
        PlanetaryBody destinationPlanet = PlanetaryBodyData.getPlanet(dialog.getDestinationPlanetName());

        // Perform calculations
        assert startingPlanet != null;
        assert destinationPlanet != null;
        double tripDistance = Metrics.relativeDistance(startingPlanet.getDistanceFromSun(), destinationPlanet.getDistanceFromSun());
        double vehicleSpeed = ScientificCalc.gravityAssistWithDrag(startingPlanet, vehicle);

        // Create trip instance and add to list of trips
        TripData.addTrip(new Trip(startingPlanet, destinationPlanet, vehicle, tripDistance, vehicleSpeed, TripData.departureDate));
    }

    /**
     * Adds a trip to the itinerary, given the user input provided.
     * The trip is created by converting the input to objects and performing calculations,
     * then it's added to the list of trips.
     * @param startingPlanetName the name of the starting planet
     * @param destinationPlanetName the name of the destination planet
     * @param vehicleName the name of the transportation vehicle
     */
    public static void addTripToItinerary(String startingPlanetName, String destinationPlanetName, String vehicleName) {
        // Convert input to objects
        TransportationVehicle vehicle = TransportationVehicleData.getVehicle(vehicleName);
        PlanetaryBody startingPlanet = PlanetaryBodyData.getPlanet(startingPlanetName);
        PlanetaryBody destinationPlanet = PlanetaryBodyData.getPlanet(destinationPlanetName);

        // Perform calculations
        assert startingPlanet != null;
        assert destinationPlanet != null;
        double tripDistance = Metrics.relativeDistance(startingPlanet.getDistanceFromSun(), destinationPlanet.getDistanceFromSun());
        double vehicleSpeed = ScientificCalc.gravityAssistWithDrag(startingPlanet, vehicle);

        // Create trip instance and add to list of trips
        TripData.addTrip(new Trip(startingPlanet, destinationPlanet, vehicle, tripDistance, vehicleSpeed, TripData.departureDate));
    }


}
