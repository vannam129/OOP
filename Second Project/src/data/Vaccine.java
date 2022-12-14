/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Vaccine implements Serializable{
    private String vaccineId;
    private String vaccineName;

    public Vaccine() {
    }

    public Vaccine(String vaccineId, String vaccineName) {
        this.vaccineId = vaccineId;
        this.vaccineName = vaccineName;
    }

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public void output() {
//        System.out.println("|    ID    |        Name        |");
        System.out.printf("|%10s|%20s|\n", vaccineId, vaccineName);
    }
}
