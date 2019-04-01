/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldnr.jse.adresse.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Tian 
 */
public class PersonnePhysique extends Personne {
    protected final StringProperty prenom;
    /**
     * Constructor with some initial data.
     * @param nom
     * @param prenom
     */
    public PersonnePhysique(String nom, String prenom) {
        super(nom);
        this.prenom = new SimpleStringProperty(prenom);
    }
    
    public String getPrenom() {
        return prenom.get();
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }
    
    public StringProperty prenomProperty() {
        return prenom;
    }
    
}
