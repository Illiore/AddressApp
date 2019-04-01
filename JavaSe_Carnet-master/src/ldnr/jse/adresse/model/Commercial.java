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
public class Commercial extends PersonnePhysique{
    protected final StringProperty code;
    /**
     * Constructor with some initial data.
     * @param nom
     * @param prenom
     */
    public Commercial(String nom, String prenom) {
        super(nom, prenom);
        this.code = new SimpleStringProperty("00001");
    }
    
    public String getCode() {
        return code.get();
    }

    public void setCode(String code) {
        this.code.set(code);
    }
    
    public StringProperty codeProperty() {
        return code;
    }
}
