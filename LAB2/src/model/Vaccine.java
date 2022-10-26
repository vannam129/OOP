/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Vaccine implements Serializable{
     private String vaccineID;
    private String nameVaccine;

    public Vaccine(String vaccineID, String nameVaccine) {
        this.vaccineID = vaccineID;
        this.nameVaccine = nameVaccine;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getNameVaccine() {
        return nameVaccine;
    }

    public void setNameVaccine(String nameVaccine) {
        this.nameVaccine = nameVaccine;
    }

    public void ouput() {
        System.out.printf("|Vaccine|%-15s|%-15s|%n", vaccineID, nameVaccine);

    }

    @Override
    public String toString() {
        return "Vaccine{" + "vaccineID=" + vaccineID + ", nameVaccine=" + nameVaccine + '}';
    }

    public String print() {
        return String.format("VACCINEID: %-15s|VACCINENAME: %-15s", vaccineID, nameVaccine);
    }
}
