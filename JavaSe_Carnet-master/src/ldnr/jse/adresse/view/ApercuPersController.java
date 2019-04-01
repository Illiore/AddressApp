/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldnr.jse.adresse.view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ldnr.jse.adresse.MainApp;
import ldnr.jse.adresse.model.PersonnePhysique;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ApercuPersController implements Initializable {
    
    @FXML
    private Label champNom;
    @FXML
    private Label champPrenom;
    @FXML
    private Label champAdresse;
    @FXML
    private Label champCP;
    @FXML
    private Label champVille;
    @FXML
    private Label champTelephone;
    @FXML
    private Label champTelephoneBis;
    @FXML
    private Label champEmail;
    

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ApercuPersController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
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
           
           // birthdayLabel.setText(...);
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
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Aucune Sélection");
            alert.setHeaderText("Aucune personne sélectionnée");
            alert.setContentText("Merci de sélectionner une personne dans la liste.");

            alert.showAndWait();
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
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
