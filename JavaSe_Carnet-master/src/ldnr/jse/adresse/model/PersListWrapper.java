/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldnr.jse.adresse.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of persons. This is used for saving the
 * list of persons to XML.
 * 
 * @author Marco Jakob
 */
@XmlRootElement(name = "persons")
public class PersListWrapper {

    private List<PersonnePhysique> persons;

    @XmlElement(name = "person")
    public List<PersonnePhysique> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonnePhysique> persons) {
        this.persons = persons;
    }
}