/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import address.model.Person;


/**
 * Dialog to edit details of a person.
 *
 * @author Sandra
 */
public class PersonEditDialogController {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField adresseField;
    @FXML
    private TextField codePostalField;
    @FXML
    private TextField villeField;
    @FXML
    private TextField numField;
    @FXML
    private TextField num2Field;
    @FXML
    private TextField mailField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        nomField.setText(person.getNom());
        prenomField.setText(person.getPrenom());
        adresseField.setText(person.getAdresse());
        codePostalField.setText(person.getCodePostal());
        villeField.setText(person.getVille());
        numField.setText(person.getNum());
        num2Field.setText(person.getNum2());
        mailField.setText(person.getMail());
        
    }

     /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setNom(nomField.getText());
            person.setPrenom(prenomField.getText());
            person.setAdresse(adresseField.getText());
            person.setCodePostal(codePostalField.getText());
            person.setVille(villeField.getText());
            person.setNum(numField.getText());
            person.setNum2(num2Field.getText());
            person.setMail(mailField.getText());
            

            okClicked = true;
            dialogStage.close();
        }
    }

     /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nomField.getText() == null || nomField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (prenomField.getText() == null || prenomField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (adresseField.getText() == null || adresseField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }

        if (codePostalField.getText() == null || codePostalField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        } /* else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(postalCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        } */

        if (villeField.getText() == null || villeField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }
        
        if (numField.getText() == null || numField.getText().length() == 0) {
            errorMessage += "No valid num!\n";
        }
        
        if (num2Field.getText() == null || num2Field.getText().length() == 0) {
            errorMessage += "No valid num2!\n";
        }
        
        if (mailField.getText() == null || mailField.getText().length() == 0) {
            errorMessage += "No valid mail!\n";
        }

        

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Champs invalides");
            alert.setHeaderText("Veuillez corriger les champs invalides.");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
    
}
