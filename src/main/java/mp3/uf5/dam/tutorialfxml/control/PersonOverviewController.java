package mp3.uf5.dam.tutorialfxml.control;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import mp3.uf5.dam.tutorialfxml.MainApp;
import mp3.uf5.dam.tutorialfxml.model.Person;
import mp3.uf5.dam.tutorialfxml.util.DateUtil;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;


    @FXML
    BarChart bchartPop;
    @FXML
    CategoryAxis xAxis;
    @FXML
    NumberAxis yAxis;

    XYChart.Series<String,Integer> dataSeries1 = new XYChart.Series();
    XYChart.Series<String,Integer> dataSeries2 = new XYChart.Series();
    XYChart.Series<String,Integer> dataSeries3 = new XYChart.Series();

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));


        xAxis.setLabel("dia");
        yAxis.setLabel("precipitació");

        dataSeries1.setName("00:00");
        dataSeries1.getData().add(new XYChart.Data<String,Integer>("dia1",10));
        dataSeries1.getData().add(new XYChart.Data<String,Integer>("dia2",5));
        dataSeries1.getData().add(new XYChart.Data<String,Integer>("dia3",5));
        bchartPop.getData().add(dataSeries1);

        dataSeries2.setName("12:00");
        dataSeries2.getData().add(new XYChart.Data<String,Integer>("dia1",6));
        dataSeries2.getData().add(new XYChart.Data<String,Integer>("dia2",7));
        dataSeries2.getData().add(new XYChart.Data<String,Integer>("dia3",8));
        bchartPop.getData().add(dataSeries2);

        dataSeries3.setName("18:00");
        dataSeries3.getData().add(new XYChart.Data<String,Integer>("dia1",15));
        bchartPop.getData().add(dataSeries3);
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }

    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param person the person or null
     */
    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            cityLabel.setText(person.getCity());
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        } else {
            // Person is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No selection");
            alert.setHeaderText("No person selected");
            alert.setContentText("Please select a person in the table.");
            alert.show();
            /*Dialogs.create()
                    .title("No Selection")
                    .masthead("No Person Selected")
                    .message("Please select a person in the table.")
                    .showWarning();*/
        }

    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No selection");
            alert.setHeaderText("No person selected");
            alert.setContentText("Please select a person in the table.");
            alert.show();

        }
    }
}