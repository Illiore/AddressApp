/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Sandra
 */
public class Person {

    private final StringProperty nom;
    private final StringProperty prenom;
    private final StringProperty adresse;
    private final StringProperty codePostal;
    private final StringProperty ville;
    private final StringProperty num;
    private final StringProperty num2;
    private final StringProperty mail;

    /**
     * Default constructor.
     */
    public Person() {
        this(null, null, null, null, null, null, null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param nom
     * @param prenom
     *
     */
    public Person(String nom, String prenom, String adresse, String codePostal, String ville, String num, String num2, String mail) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.adresse = new SimpleStringProperty(adresse);
        this.codePostal = new SimpleStringProperty(codePostal);
        this.ville = new SimpleStringProperty(ville);
        this.num = new SimpleStringProperty(num);
        this.num2 = new SimpleStringProperty(num2);
        this.mail = new SimpleStringProperty(mail);
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

    public String getPrenom() {
        return prenom.get();
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public StringProperty prenomProperty() {
        return prenom;
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

    public String getCodePostal() {
        return codePostal.get();
    }

    public void setCodePostal(String codePostal) {
        this.codePostal.set(codePostal);
    }

    public StringProperty codePostalProperty() {
        return codePostal;
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

    public String getNum() {
        return num.get();
    }

    public void setNum(String num) {
        this.num.set(num);
    }

    public StringProperty numProperty() {
        return num;
    }

    public String getNum2() {
        return num2.get();
    }

    public void setNum2(String num2) {
        this.num2.set(num2);
    }

    public StringProperty num2Property() {
        return num2;
    }

    public String getMail() {
        return mail.get();
    }

    public void setMail(String mail) {
        this.mail.set(mail);
    }

    public StringProperty mailProperty() {
        return mail;
    }
}
