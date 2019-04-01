/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldnr.jse.adresse.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ldnr.jse.adresse.model.Commercial;

/**
 * FXML Controller class
 *
 * @author stag
 */
public class CommercialEditDialogController implements Initializable {

    @FXML
    private TextField champNom;
    @FXML
    private TextField champPrenom;
    @FXML
    private TextField champAdresse;
    @FXML
    private TextField champCodePostal;
    @FXML
    private TextField champVille;
    @FXML
    private TextField champTelephone;
    @FXML
    private TextField champTelephoneBis;
    @FXML
    private TextField champEmail;   
    @FXML
    private TextField champCode; 


    private Stage dialogStage;
    private Commercial person;
    private boolean okClicked = false;

    /**
     * Initialise le controle, dès que le fxml a été chargé
     * 
     */
    @FXML
    private void initialize() {
    }

    /**
     * Définit le stage de cette fenetre
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Définit la personne éditée dans cette fenetre
     *
     * @param person
     */
    public void setPerson(Commercial person) {
        this.person = person;

        champNom.setText(person.getNom());
        champPrenom.setText(person.getPrenom());
        champAdresse.setText(person.getAdresse());
        champCodePostal.setText(person.getCP());
        champVille.setText(person.getVille());
        champTelephone.setText(person.getTelephone());
        champTelephoneBis.setText(person.getTelephoneBis());
        champEmail.setText(person.getEmail());
        champCode.setText(person.getCode());
        
    }

    /**
     * Renvoie True si l'utilisateur clique sur OK, sinon False
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Appelé quand ok est cliqué.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setNom(champNom.getText());
            person.setPrenom(champPrenom.getText());
            person.setAdresse(champAdresse.getText());
            person.setCP(champCodePostal.getText());
            person.setVille(champVille.getText());
            person.setTelephone(champTelephone.getText());
            person.setTelephoneBis(champTelephoneBis.getText());
            person.setEmail(champEmail.getText());
            person.setCode(champCode.getText());
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Applelé au clic sur cancel
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validation des entrées
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (champNom.getText() == null || champNom.getText().length() == 0) {
            errorMessage += "Nom invalide\n";
        }
        if (champPrenom.getText() == null || champPrenom.getText().length() == 0) {
            errorMessage += "Prénom invalide\n";
        }
        if (champAdresse.getText() == null || champAdresse.getText().length() == 0) {
            errorMessage += "Adresse invalide\n";
        }
        if (champCodePostal.getText() == null || champCodePostal.getText().length() == 0) {
            errorMessage += "Code Postal invalide\n";
        } 
        if (champVille.getText() == null || champVille.getText().length() == 0) {
            errorMessage += "Ville invalide\n";
        }
        if (champTelephone.getText() == null || champTelephone.getText().length() == 0) {
            errorMessage += "Telephone invalide\n";
        }
        if (champTelephoneBis.getText() == null || champTelephoneBis.getText().length() == 0) {
            errorMessage += "Telephone invalide\n";
        }
        if (champEmail.getText() == null || champEmail.getText().length() == 0) {
            errorMessage += "email invalide\n";
        }
        if (champCode.getText() == null || champCode.getText().length() == 0) {
            errorMessage += "email invalide\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Affiche le message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Entrées incorrectes");
            alert.setHeaderText("Merci de corriger les champs erronés");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}