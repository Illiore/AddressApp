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
import ldnr.jse.adresse.model.Personne;
import ldnr.jse.adresse.model.PersonneMorale;
import ldnr.jse.adresse.model.PersonnePhysique;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ApercuListeController {
    @FXML
    private TableView<PersonnePhysique> personTable;
    @FXML
    private TableColumn<PersonnePhysique, String> colNom;
    @FXML
    private TableColumn<PersonnePhysique, String> colVille;

    @FXML
    private Label champNom;
    @FXML
    private Label champPrenom;
    @FXML
    private Label champAdresse;
    @FXML
    private Label champCodePostal;
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
    public ApercuListeController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        colNom.setCellValueFactory(
                cellData -> cellData.getValue().nomProperty());
        colVille.setCellValueFactory(
                cellData -> cellData.getValue().villeProperty());

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
        personTable.setItems(mainApp.getPersonnePhysiqueData());
    }
    
    /**
    * Fills all text fields to show details about the person.
    * If the specified person is null, all text fields are cleared.
    *
    * @param person the person or null
    */
    
   private void showPersonDetails(PersonnePhysique person) {
       if (person != null) {
           // Fill the labels with info from the person object.
           champNom.setText(person.getNom());
           champPrenom.setText(person.getPrenom());
           champAdresse.setText(person.getAdresse());
           champCodePostal.setText(person.getCP());
           champVille.setText(person.getVille());           
           champTelephone.setText(person.getTelephone());           
           champTelephoneBis.setText(person.getTelephoneBis());                    
           champEmail.setText(person.getEmail());
           
           
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
       Personne tempPerson = new PersonnePhysique("","");
       boolean okClicked = mainApp.showPersonOverview(tempPerson);
       if (okClicked) {
           mainApp.getPersonnePhysiqueData().add(tempPerson);
       }
   }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        PersonnePhysique selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersEditDialog(selectedPerson);
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
}