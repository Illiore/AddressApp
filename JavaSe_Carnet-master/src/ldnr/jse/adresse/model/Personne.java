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
public abstract class Personne {
    /*
    Avec JavaFX il est courant d’utiliser les Properties pour tous les champs de classe. 
    Une Property (propriété) nous permet, par exemple, d’être automatiquement averti lorsque la variable email ou toute autre variable a été modifiée. 
    Ceci nous aide à maintenir la view synchronisée avec les données. 
    */
    protected final StringProperty nom;
    protected final StringProperty email;
    protected final StringProperty telephone;
    protected final StringProperty telephoneBis;
    protected final StringProperty adresse;
    protected final StringProperty ville;
    protected final StringProperty cp;
    

    /**
     * Default constructor.
     */
    
    public Personne() {
        this(null);
    }
    
    /**
     * Constructor with some initial data.
     * 
     * @param nom
     */
    public Personne(String nom) {
        this.nom = new SimpleStringProperty(nom);
        
        // Some initial dummy data, just for convenient testing.
        this.email = new SimpleStringProperty("email");
        this.telephone = new SimpleStringProperty("0600000000");
        this.telephoneBis = new SimpleStringProperty("0600000000");
        this.adresse = new SimpleStringProperty("some adresse");
        this.ville = new SimpleStringProperty("some ville");
        this.cp = new SimpleStringProperty("1234");   
    }
    
    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }
    
    public StringProperty nomProperty() {
        return nom;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
    
    public StringProperty emailProperty() {
        return email;
    }

    public String getAdresse() {
        return adresse.get();
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }
    
    public StringProperty adresseProperty() {
        return adresse;
    }

    public String getCP() {
        return cp.get();
    }

    public void setCP(String cp) {
        this.cp.set(cp);
    }
    
    public StringProperty cpProperty() {
        return cp;
    }

    public String getVille() {
        return ville.get();
    }

    public void setVille(String ville) {
        this.ville.set(ville);
    }
    
    public StringProperty villeProperty() {
        return ville;
    }

    public String getTelephone() {
        return telephone.get();
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }
    
    public StringProperty telephoneProperty() {
        return telephone;
    }
    
    public String getTelephoneBis() {
        return telephoneBis.get();
    }

    public void setTelephoneBis(String telephoneBis) {
        this.telephoneBis.set(telephoneBis);
    }
    
    public StringProperty telephoneBisProperty() {
        return telephoneBis;
    }
}
