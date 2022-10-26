/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author PC
 */
import database.WriteVaccine;
import java.io.IOException;
import java.util.ArrayList;
import model.Vaccine;
public class VaccineManager {
     private ArrayList<Vaccine> vaccineList = new ArrayList<>();

    public VaccineManager() throws ClassNotFoundException, IOException {
        readfile();
    }

    public void print() {
        if (vaccineList.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            for (int i = 0; i < vaccineList.size(); i++) {
                vaccineList.get(i).ouput();
            }
        }
    }

    public Vaccine searchVaccine(String vaccineID) {
        if (vaccineList.isEmpty()) {
            return null;
        } else {

            for (int i = 0; i < vaccineList.size(); i++) {
                if (vaccineID.equals(vaccineList.get(i).getVaccineID())) {
                    return vaccineList.get(i);
                }
            }
            return null;
        }
    }

    private void readfile() throws ClassNotFoundException, IOException {
        WriteVaccine vaccine = new WriteVaccine();
        vaccineList = vaccine.readArrayPerObjectFromFile();
    }
}
