package ldnr.jse.adresse.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ldnr.jse.adresse.model.PersonneMorale;

/**
 * Fenetre d'édition d'une personne physique
 *
 * @author Bastien
 */
public class PersMoraleEditDialogController implements Initializable{

    @FXML
    private TextField champNom;
    @FXML
    private TextField champGerant;
    @FXML
    private TextField champAdresse;
    @FXML
    private TextField champCodePostal;
    @FXML
    private TextField champVille;
    @FXML
    private TextField champFax;
    @FXML
    private TextField champTelephone;
    @FXML
    private TextField champTelephoneBis;
    @FXML
    private TextField champEmail;    


    private Stage dialogStage;
    private PersonneMorale person;
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
    public void setPerson(PersonneMorale person) {
        this.person = person;

        champNom.setText(person.getNom());
        champGerant.setText(person.getGerant());
        champAdresse.setText(person.getAdresse());
        champCodePostal.setText(person.getCP());
        champVille.setText(person.getVille());
        champFax.setText(person.getFax());
        champTelephone.setText(person.getTelephone());
        champTelephoneBis.setText(person.getTelephoneBis());
        champEmail.setText(person.getEmail());
        
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
            person.setGerant(champGerant.getText());
            person.setAdresse(champAdresse.getText());
            person.setCP(champCodePostal.getText());
            person.setVille(champVille.getText());
            person.setFax(champFax.getText());
            person.setTelephone(champTelephone.getText());
            person.setTelephoneBis(champTelephoneBis.getText());
            person.setEmail(champEmail.getText());
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
        if (champGerant.getText() == null || champGerant.getText().length() == 0) {
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
         if (champFax.getText() == null || champFax.getText().length() == 0) {
            errorMessage += "Telephone invalide\n";
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
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Affiche le message d'erreur
            Alert alert = new Alert(AlertType.ERROR);
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