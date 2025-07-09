/**
 * This class is used to create a GUI for the Planetary Travel Calculator application (the {@link assignment.AppRouter} class)
 * @author J. Vidal
 * @version 2.0
 * 07.07.2025
 */

package assignment.ui;
import assignment.AppRouter;
import assignment.data.PlanetaryBodyData;
import assignment.data.TransportationVehicleData;
import assignment.data.TripData;
import assignment.test.TestApplicationProperties;
import assignment.test.util.OutputExcelHandler;
import assignment.test.util.TaskManager;
import assignment.test.util.UIHandler;
import assignment.trip.Trip;
import assignment.util.AbstractUtilityClass;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * This class is used to create a GUI for the Planetary Travel Calculator application
 */
public class GUI extends Application {
	/**
	 * A logger object for this class
	 */
	private static final Logger logger = LogManager.getLogger(GUI.class.getName());
    /**
	 * The path to the CSS style sheet
	 */
	private final String stylesheet = "/styles.css";
	/**
	 * The path to the property file
	 */
	File propertyFile;
    /**
	 * A text field for storing the value of the date input field
	 */
	TextField dateInput;
	/**
	 * A ToggleGroup for the precision radio buttons
	 */
	ToggleGroup precisionInputGroup;
	/**
	 * A text field for storing the value of the start planet input field
	 */
	TextField startPlanetInput;
	/**
	 * A text field for storing the value of the destination planet input field
	 */
	TextField destinationPlanetInput;
	/**
	 * A text field for storing the value of the vehicle input field
	 */
	TextField vehicleInput;
	/**
	 * A stack pane for managing the application layers along the z-axis
	 */
	StackPane root;
	/**
	 * A string for the class name of the screen header
	 */
	String screenHeaderClass = "screen-header";
	/**
	 * A string for the class name of the details path
	 */
	String detailsPathClass = "details-path";
	/**
	 * The radio button for estimated precision
	 */
	RadioButton estimatedPrecision;
	/**
	 * The radio button for precise precision
	 */
	RadioButton precisePrecision;
	/**
	 * The combo box for the start planet
	 */
	ComboBox<String> startPlanetComboBox;
	/**
	 * The combo box for the destination planet
	 */
	ComboBox<String> destinationPlanetComboBox;
	/**
	 * The combo box for the vehicle
	 */
	ComboBox<String> vehicleComboBox;

    /**
	 * This is the main method for the GUI class. It launches the application.
	 * @param args ignored
	 */
	public static void main(String[] args) {
		// Set properties file path by default or from command line
		AppRouter.enableGUI();

		// Launch the application
		launch(args);
	}

	/**
	 * This method is called when the application starts and sets up the initial UI components via the first scene.
	 * @param primaryStage the primary stage for the application
	 */
	@Override
	public void start(@NotNull Stage primaryStage) {
	// CREATE A STACK PANE FOR Z-INDEX BASED LAYERING
		// Create a File object with the path to the GIF file
		// Create a new StackPane and set the background
		root = getContainerWithBackgroundImage();

	// CREATE A GRIDPANE FOR LAYOUT OF HIGHEST Z-INDEX ELEMENTS
		// Create a GridPane
		GridPane layoutGrid = new GridPane();

		// Create a title label
		Label title = new Label("Planetary Travel Calculator");
		title.getStyleClass().add(screenHeaderClass);
		Label subHeader = new Label("Written by Joel Vidal");
		subHeader.getStyleClass().add("sub-header");

		// Create a VBox for the title and sub-header
		VBox titleBox = new VBox(title, subHeader);
		titleBox.setSpacing(10);
		titleBox.setAlignment(Pos.CENTER);

		// Create a start button
		HBox buttonBox = createButtonBox("start");

		// Create a VBox for the header and start button
		VBox headerBox = new VBox(titleBox, buttonBox);
		headerBox.setSpacing(40);
		headerBox.setAlignment(Pos.TOP_CENTER);
		layoutGrid.add(headerBox, 0, 0);

		// Set position of HBox
		layoutGrid.setAlignment(Pos.CENTER);

		// Add layout grid to stack pane
		root.getChildren().add(layoutGrid);

	// ADD THE STACK PANE TO THE SCENE
		// Create a scene with the HBox as its root node
		Scene scene = new Scene(root, 1080,720);

		// Set the style sheet
		scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource(stylesheet)).toExternalForm());

		// Add the scene to the stage
		primaryStage.setScene(scene);

		// Set the title of the window
        String windowTitle = "Planetary Travel Calculator";
        primaryStage.setTitle(windowTitle);

		// Show the window
		primaryStage.show();
	}

	/**
	 * This method is used to create the file input screen.
	 */
	public void fileInputScreen() {
		// Clear stack pane
		root.getChildren().clear();

		// Create screen header
		Label headerLabel = new Label("Properties File");
		headerLabel.getStyleClass().add(screenHeaderClass);

		// Create a HBox for the header
		HBox headerBox = new HBox(headerLabel);
		headerBox.setAlignment(Pos.CENTER);

		// Create a GridPane
		GridPane layoutGrid = new GridPane();

		// Create file input fields
		Label planetDataLabel = new Label("Choose a property file: ");
		Button spaceFileButton = propertyFile == null ? new Button("Browse") : new Button("Replace File");
		spaceFileButton.setOnAction(event -> {
			FileChooser fileChooser = new FileChooser();
			propertyFile = fileChooser.showOpenDialog(root.getScene().getWindow());

			// refresh screen
			fileInputScreen();
		});

		// Create an HBox's for the file input fields
		HBox planetDataBox = propertyFile == null ? new HBox(planetDataLabel, spaceFileButton) : new HBox(planetDataLabel, new Label(String.format("%s...", propertyFile.getName())), spaceFileButton);

		// Set input field spacing
		planetDataBox.setSpacing(20);

		// Create Next button
		HBox buttonBox = createButtonBox("next-preferences");

		// Add content to content layout grid
		layoutGrid.add(headerBox, 0, 0);
		layoutGrid.add(planetDataBox, 0, 1);
		layoutGrid.add(buttonBox, 0, 2);

		// Set grid spacing
		layoutGrid.setVgap(20);

		layoutGrid.setAlignment(Pos.CENTER);

		// Add layout grid to stack pane
		root.getChildren().add(layoutGrid);
	}

	/**
	 * This method is used to create the date input screen.
	 */
	public void dateInput() {
		// Clear stack pane
		root.getChildren().clear();

		// Create screen header
		Label headerLabel = new Label("Trip Date & Precision");
		headerLabel.getStyleClass().add(screenHeaderClass);

		// Create a HBox for the header
		HBox headerBox = new HBox(headerLabel);
		headerBox.setAlignment(Pos.CENTER);

		// Create a GridPane
		GridPane layoutGrid = new GridPane();

		// Create date label & date input field controls with today's date by default
		LocalDate today = LocalDate.now();
		Label dateLabel = new Label("Departure Date: ");
		dateInput = new TextField(String.format("%02d/%02d/%04d", today.getMonthValue(), today.getDayOfMonth(), today.getYear()));
		
		// Create an HBox for the date label & input field
		HBox dateInputBox = new HBox(dateLabel, dateInput);

		// Create precision label & precision input field controls
		Label precisionLabel = new Label("Calculation Precision: ");
		estimatedPrecision = new RadioButton("Estimated");
		precisePrecision = new RadioButton("Precise");

		// Add precision radio buttons to ToggleGroup
		precisionInputGroup = new ToggleGroup();
		estimatedPrecision.setToggleGroup(precisionInputGroup);
		estimatedPrecision.setSelected(true);
		precisePrecision.setToggleGroup(precisionInputGroup);

		// Create VBox for precision selectors (radio buttons)
		VBox toggleBox = new VBox(estimatedPrecision, precisePrecision);

		// Set input spacing for toggleBox
		toggleBox.setSpacing(5);
		
		// Create HBox for precision input container
		HBox precisionInputContainer = new HBox(precisionLabel, toggleBox);

		// Set input field spacing
		dateInputBox.setSpacing(20);
		precisionInputContainer.setSpacing(20);

		// Create Next button
		HBox buttonBox = createButtonBox("next-planetary-input");

		// Add content to content layout grid
		layoutGrid.add(headerBox, 0, 0);
		layoutGrid.add(dateInputBox, 0, 1);
		layoutGrid.add(precisionInputContainer, 0, 2);
		layoutGrid.add(buttonBox, 0, 3);

		// Set grid spacing
		layoutGrid.setVgap(20);

		layoutGrid.setAlignment(Pos.CENTER);

		// Add layout grid to stack pane
		root.getChildren().add(layoutGrid);
	}

	/**
	 * This method is used to create the planetary input screen.
	 */
	public void planetaryInputScreen() {
		// Clear stack pane
		root.getChildren().clear();

		// Create screen header
		Label headerLabel = new Label("Trip Information");
		headerLabel.getStyleClass().add(screenHeaderClass);

		// Create a HBox for the header
		HBox headerBox = new HBox(headerLabel);
		headerBox.setAlignment(Pos.CENTER);

		// Create a GridPane
		GridPane layoutGrid = new GridPane();

		// Store list of planets and vehicles for input fields
		String[] planetNames = PlanetaryBodyData.getPlanetNames();
		String[] vehicleNames = TransportationVehicleData.getVehicleNames();

		// Create planet label & planet input field controls
		Label startingPlanetLabel = new Label("Starting Planet: ");
		Label destinationPlanetLabel = new Label("Destination Planet: ");
		Label vehicleLabel = new Label("Vehicle: ");
		startPlanetComboBox = new ComboBox<>(FXCollections.observableArrayList(planetNames));
		destinationPlanetComboBox = new ComboBox<>(FXCollections.observableArrayList(planetNames));
		vehicleComboBox = new ComboBox<>(FXCollections.observableArrayList(vehicleNames));

		// Set default values for input fields
		startPlanetComboBox.setValue(planetNames[0]);
		destinationPlanetComboBox.setValue(planetNames[1]);
		vehicleComboBox.setValue(vehicleNames[0]);

		// Add planet label & planet input field controls to HBox
		GridPane planetInputBox = new GridPane();
		planetInputBox.add(startingPlanetLabel, 0, 0);
		planetInputBox.add(startPlanetComboBox, 1, 0);
		planetInputBox.add(destinationPlanetLabel, 0, 1);
		planetInputBox.add(destinationPlanetComboBox, 1, 1);
		planetInputBox.add(vehicleLabel, 0, 2);
		planetInputBox.add(vehicleComboBox, 1, 2);

		// Set input grid spacing
		planetInputBox.setHgap(20);
		planetInputBox.setVgap(20);
		planetInputBox.setAlignment(Pos.CENTER);

		// Create HBox for continue button
		HBox buttonBox = createButtonBox("add trip");

		// Add content to content layout grid
		layoutGrid.add(headerBox, 0, 0);
		layoutGrid.add(planetInputBox, 0, 1);
		layoutGrid.add(buttonBox, 0, 2);


		// Set grid spacing
		layoutGrid.setVgap(20);
		layoutGrid.setAlignment(Pos.CENTER);

		// Add layout grid to stack pane
		root.getChildren().add(layoutGrid);
	}

	/**
	 * This method is used to create the export preview screen.
	 */
	public void previewScreen() {
		// Clear stack pane
		root.getChildren().clear();

		// Create a GridPane
		GridPane layoutGrid = new GridPane();
		// Create display elements for results
		// Create header label
		Label headerLabel = new Label("Results Preview");
		headerLabel.getStyleClass().add(screenHeaderClass);
		// Create results table
		GridPane resultsTable = new GridPane();

		// Populate results table
		// Get itinerary from TripData
		List<Trip> itinerary = TripData.getTrips();
		// Add column headers with assigned style classes
		Label startingPlanetHeader = new Label("Departure");
		Label destinationPlanetHeader = new Label("Arrival");
		Label vehicleHeader = new Label("Vehicle");
		Label departureDateHeader = new Label("Depart Date");
		Label arrivalDateHeader = new Label("Arrival Date");
		Label durationHeader = new Label("Duration (hrs)");

        String tableHeaderClass = "table-header";
        startingPlanetHeader.getStyleClass().add(tableHeaderClass);
		destinationPlanetHeader.getStyleClass().add(tableHeaderClass);
		vehicleHeader.getStyleClass().add(tableHeaderClass);
		departureDateHeader.getStyleClass().add(tableHeaderClass);
		arrivalDateHeader.getStyleClass().add(tableHeaderClass);
		durationHeader.getStyleClass().add(tableHeaderClass);

		resultsTable.add(startingPlanetHeader, 0, 0);
		resultsTable.add(destinationPlanetHeader, 1, 0);
		resultsTable.add(vehicleHeader, 2, 0);
		resultsTable.add(departureDateHeader, 3, 0);
		resultsTable.add(arrivalDateHeader, 4, 0);
		resultsTable.add(durationHeader, 5, 0);
		// Add rows for each trip
		for (int i = 0; i < itinerary.size(); i++) {
			Trip trip = itinerary.get(i);

			Label startingPlanetData = new Label(trip.getStartingPlanet());
			Label destinationPlanetData = new Label(trip.getDestinationPlanet());
			Label vehicleData = new Label(trip.getVehicle().getVehicleName());
			String[] departureDate = trip.getDepartureDate().toString().split("-");
			String[] arrivalDate = trip.getArrivalDate().toString().split("-");
			Label departureDateData = new Label(departureDate[1] + "/" + departureDate[2] + "/" + departureDate[0]);
			Label arrivalDateData = new Label(arrivalDate[1] + "/" + arrivalDate[2] + "/" + arrivalDate[0]);
			Label durationData = new Label(String.format("%.8f", trip.getTravelDurationInHours()));


            String tableDataClass = "table-data";
            startingPlanetData.getStyleClass().add(tableDataClass);
			destinationPlanetData.getStyleClass().add(tableDataClass);
			vehicleData.getStyleClass().add(tableDataClass);
			departureDateData.getStyleClass().add(tableDataClass);
			arrivalDateData.getStyleClass().add(tableDataClass);
			durationData.getStyleClass().add(tableDataClass);

			resultsTable.add(startingPlanetData, 0, i + 1);
			resultsTable.add(destinationPlanetData, 1, i + 1);
			resultsTable.add(vehicleData, 2, i + 1);
			resultsTable.add(departureDateData, 3, i + 1);
			resultsTable.add(arrivalDateData, 4, i + 1);
			resultsTable.add(durationData, 5, i + 1);
		}

		// Set column widths
		resultsTable.getColumnConstraints().addAll(
				new ColumnConstraints(100),
				new ColumnConstraints(100),
				new ColumnConstraints(150),
				new ColumnConstraints(120),
				new ColumnConstraints(120),
				new ColumnConstraints(150)
		);

		// Set gap between columns
		resultsTable.setHgap(5);

		// Create a VBox for display elements
		VBox displayBox = new VBox(headerLabel, resultsTable);
		displayBox.setSpacing(20);
		displayBox.setAlignment(Pos.TOP_CENTER);
		displayBox.setPrefHeight(500);


		// Create two buttons; "Add Another" and "Export"
		HBox buttonBox = createButtonBox("add another");
		HBox buttonBox2 = createButtonBox("export");

		// Create GridPane for buttons
		GridPane buttons = new GridPane();
		buttons.add(buttonBox, 0, 0);
		buttons.add(buttonBox2, 1, 0);
		buttons.setAlignment(Pos.CENTER);
		buttons.setHgap(20);

		// Add content to content layout grid
		layoutGrid.add(displayBox, 0, 0);
		layoutGrid.add(buttons, 0, 1);

		// Set grid spacing
		layoutGrid.setVgap(20);
		layoutGrid.setAlignment(Pos.CENTER);

		// Add layout grid to stack pane
		root.getChildren().add(layoutGrid);
	}

	/**
	 * This method is used to create the try again screen. Used when the output directory is full.
	 */
	public void tryAgainScreen() {
		// Clear stack pane
		root.getChildren().clear();

		// Create screen header
		Label headerLabel = new Label("Oops! Something went wrong.");
		headerLabel.getStyleClass().add(screenHeaderClass);

		// Create a HBox for the header
		HBox headerBox = new HBox(headerLabel);
		headerBox.setAlignment(Pos.CENTER);

		// Create label
		Label errorLabel = new Label("It appears the output directory is full. Please empty it and try again.");
		Label errorLabel2 = new Label("Output Directory: ");
		Label outDirectoryPath = new Label(TestApplicationProperties.APP_RESOURCES_PATH + "out");

		// Assign style classes
		headerLabel.getStyleClass().add("error-header");
		errorLabel.getStyleClass().add("error-info");
		errorLabel2.getStyleClass().add("error-details");
		outDirectoryPath.getStyleClass().add(detailsPathClass);

		// Create VBox for labels
		VBox errorBox = new VBox(errorLabel);
		errorBox.setAlignment(Pos.CENTER);

		VBox errorBox2 = new VBox(errorLabel2, outDirectoryPath);
		errorBox2.setSpacing(20);
		errorBox2.setAlignment(Pos.CENTER);

		// Create an HBox for the try again button
		HBox buttonBox = createButtonBox("try again");

		// Add label to HBox
		VBox errorMessageBox = new VBox(headerBox, errorBox, errorBox2, buttonBox);
		errorMessageBox.setSpacing(40);
		errorMessageBox.setAlignment(Pos.CENTER);

		// Add VBox to StackPane
		root.getChildren().add(errorMessageBox);
	}

	/**
	 * This method is used to create the export screen.
	 */
	public void exportScreen() {
		// Clear stack pane
		root.getChildren().clear();

		// Create screen header
		Label headerLabel = new Label("Export Details");
		headerLabel.getStyleClass().add(screenHeaderClass);

		// Create a HBox for the header
		HBox headerBox = new HBox(headerLabel);
		headerBox.setAlignment(Pos.CENTER);

		// Create label
		Label exportLabel = new Label("Excel file exported successfully to: ");
		Label excelFileName = new Label(TaskManager.outputExcelFileName);
		Label exportLabel2 = new Label("XML file exported successfully: ");
		Label xmlFileName = new Label(TaskManager.outputXMLFileName);

		// Assign style classes
		headerLabel.getStyleClass().add("success");
		excelFileName.getStyleClass().add(detailsPathClass);
		xmlFileName.getStyleClass().add("details-path");

		// Create VBox for labels
		VBox exportBox = new VBox(exportLabel, excelFileName);
		exportBox.setSpacing(20);
		exportBox.setAlignment(Pos.CENTER);

		VBox exportBox2 = new VBox(exportLabel2, xmlFileName);
		exportBox2.setSpacing(20);
		exportBox2.setAlignment(Pos.CENTER);

		// Add label to HBox
		VBox exportMessageBox = new VBox(headerBox, exportBox, exportBox2);
		exportMessageBox.setSpacing(40);
		exportMessageBox.setAlignment(Pos.CENTER);

		// Add VBox to StackPane
		root.getChildren().add(exportMessageBox);
	}

	/**
	 * This method is used to create a new StackPane with a background image.
	 * @return the new StackPane
	 */
	private @NotNull StackPane getContainerWithBackgroundImage() {
		// Create a File object with the path to the GIF file
        URL bgImagePath = getClass().getResource("/background.gif");
		// Check if the file exists
        try{
			assert bgImagePath != null;
		}
        catch ( NullPointerException e) {
			logger.error("GIF file not found");
		}
		// Create a new Image object from the GIF file
		Image image = new Image(bgImagePath.toExternalForm());

		// Create a new BackgroundImage object from the Image
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

		// Create a new Background object from the BackgroundImage
		Background background = new Background(backgroundImage);

		// Create a new StackPane and set the background
		StackPane newStackPane = new StackPane();
		newStackPane.setBackground(background);

		return newStackPane;
	}

	/**
	 * This method is used to create an HBox object containing a button for the GUI based on the type. The type is determined by the buttons screen origin. According to the type, the button will have different functionality and a different destination.
	 * @param type the type of button
	 * @return An HBox object containing the specified button
	 */
	@SuppressWarnings("unused")
	private @NotNull HBox createButtonBox(@NotNull String type) {
		HBox buttonBox = new HBox();
		Button button = null;
		// Create button based on type
		switch (type) {
			case "start": {
				button = new Button("Start");
				button.setOnAction(e -> {
					// Trigger next screen
					logger.info("Application starting. Moving to file input screen..");
					fileInputScreen();
				});
				break;
			}
			case "next-preferences": {
				button = new Button("Next");
				button.setOnAction(e -> {
					// Trigger next screen
                    try {
						logger.info("Loading preferences..");
                        AppRouter.main(propertyFile);
						logger.info("Application starting. Moving to date input screen..");
						dateInput();
                    } catch (Exception ex) {
						logger.error("Failed to load preferences.");
                    }
				});
				break;
			}
			case "next-planetary-input": {
				button = new Button("Next");
				button.setOnAction(e -> {
					// Pass date input and precision to TripData object
					try {
						// Set a fixed date for the program according the user input
						String[] rawDate = dateInput.getText().split("/");
						int month = Integer.parseInt(rawDate[0]);
						int day = Integer.parseInt(rawDate[1]);
						int year = Integer.parseInt(rawDate[2]);
						TripData.setDepartureDate(LocalDate.of(year, month, day));
						// Set a fixed precision according to user input
						Trip.setPrecise(precisePrecision.isSelected());
						logger.info("Date & precision set.");
						// Update mathematical constants according to the selected precision
						logger.info("Updating constants.");
						AbstractUtilityClass.updateConstants();
						logger.info("Constants updated.");
						// Trigger next screen
						logger.info("Moving to planetary input screen..");
						planetaryInputScreen();
					}
					catch (NullPointerException ex) {
						// Display error message
						ex.printStackTrace();
						logger.error(ex.getMessage());
					}
				});
				break;
			}
			case "add trip": {
				button = new Button("Add Trip");
				button.setOnAction(e -> {
					// Pass planet inputs to TripData
					logger.info("Adding trip to itinerary.");
					UIHandler.addTripToItinerary(startPlanetComboBox.getValue(), destinationPlanetComboBox.getValue(), vehicleComboBox.getValue());
					logger.info("Trip added.");
					// Trigger next screen
					logger.info("Moving to preview screen..");
					previewScreen();
				});
				break;
			}
			case "add another": {
				button = new Button("Add Another");
				button.setOnAction(e -> {
					// Trigger next screen
					logger.info("Moving back to planetary input screen..");
					planetaryInputScreen();
				});
				break;
			}
			case "export": {
				button = new Button("Export");
				button.setOnAction(e -> {
					// Check if export is possible
					if (Boolean.TRUE.equals(OutputExcelHandler.checkDirectory())) {
						tryAgainScreen();
					}
					else {
						// Export results
						initializeExport();
						// Trigger next screen
						exportScreen();
					}
				});
				break;
			}
			case "try again": {
				button = new Button("Try Again");
				button.setOnAction(e -> {
					// Check if export is possible
					if (Boolean.TRUE.equals(OutputExcelHandler.checkDirectory())) {
						tryAgainScreen();
					}
					else {
						// Export results
						initializeExport();
						// Trigger next screen
						exportScreen();
					}
				});
				break;
			}
			default: {
				break;
			}
		}

		// Add button to HBox
		buttonBox.getChildren().add(button);
		// Center the button within the HBox
		buttonBox.setAlignment(Pos.CENTER);
		return buttonBox;
	}

	/**
	 * This method is used to export the results.
	 */
	private void initializeExport() {
		logger.info("Exporting results..");
		TaskManager.outputTripResults();
		logger.info("Results exported.");
	}
}
