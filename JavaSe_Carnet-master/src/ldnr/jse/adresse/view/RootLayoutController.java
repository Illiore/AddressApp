
package ldnr.jse.adresse.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import ldnr.jse.adresse.MainApp;

/**
 * Controleur du RootLayout. Le root layout contient le menu de bases pour la gestion du fichier essentiellement, permet de sauvegarder ...
 * 
 * @author Bastien
 */
public class RootLayoutController {

    private MainApp mainApp;

    /**
     * Appelé par main app, pour donner une référence vers lui meme.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Créer un carnet d'adresse vide.
     */
    @FXML
    private void handleNew() {
        mainApp.getPersonData().clear();
        mainApp.setPersonFilePath(null);
    }

    /**
     * Ouvre un explorateur pour chercher le fichier à ouvrir
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // filtre d'extension
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Ouvre le menu 
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadPersonDataFromFile(file);
        }
    }

    /**
     * Sauvegarde vers le fichier actuellement ouvert
     * S'il n'y en a pas ouvre le sauvegarder sous
     */
    @FXML
    private void handleSave() {
        File personFile = mainApp.getPersonFilePath();
        if (personFile != null) {
            mainApp.savePersonDataToFile(personFile);
        } else {
            handleSaveAs();
        }
    }

    /**
     * Ouvre une fenetre pour permettre à l'utilisateur de choisir où sauvegarder
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Filtre l'extension
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // ouvre la fenetre de sauvegarde
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // On s'assure qu'il s'agit de la bonne extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.savePersonDataToFile(file);
        }
    }

    /**
     * Fenetre à propos.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("AddressApp");
        alert.setHeaderText("About");
        alert.setContentText("Author: Marco Jakob\nWebsite: http://code.makery.ch");

        alert.showAndWait();
    }

    /**
     * Ferme l'application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}