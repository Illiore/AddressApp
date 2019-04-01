
package ldnr.jse.adresse;
  
import java.io.IOException;

import ldnr.jse.adresse.view.RootLayoutController;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ldnr.jse.adresse.model.Commercial;
import ldnr.jse.adresse.model.PersonneMorale;
import ldnr.jse.adresse.model.PersonnePhysique;
import ldnr.jse.adresse.view.ApercuPersController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    /**
     * The data as an observable list of PersonnePhysique, PersonneMorale, Commecial.
     */
    private final ObservableList<PersonnePhysique> personnePhysiqueData = FXCollections.observableArrayList();
    private final ObservableList<PersonneMorale> personneMoraleData = FXCollections.observableArrayList();
    private final ObservableList<Commercial> commercialData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        personnePhysiqueData.add(new PersonnePhysique("Alan", "Walker"));
        personnePhysiqueData.add(new PersonnePhysique("Ed", "Sheeran"));
        personneMoraleData.add(new PersonneMorale("SONY Music"));
        personneMoraleData.add(new PersonneMorale("Universal Music"));
        commercialData.add(new Commercial("Victoria", "Buckerham"));
        commercialData.add(new Commercial("David", "Buckerham"));
    }
  
    /**
     * Returns the data as an observable list of all three models. 
     * @return
     */
    public ObservableList<PersonnePhysique> getPersonnePhysiqueData() {
        return personnePhysiqueData;
    }
    public ObservableList<PersonneMorale> getPersonneMoraleData() {
        return personneMoraleData;
    }
    public ObservableList<Commercial> getCommercialData() {
        return commercialData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ApercuPers.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            
            // Give the controller access to the main app.
            ApercuPersController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
        }
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
