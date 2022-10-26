/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import tools.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *
 * @author PC
 */
public class VaccineList implements FileOperation {

    ArrayList<Vaccine> vaccineList;
    File v = new File("vaccine.txt");

    public VaccineList() {
        vaccineList = new ArrayList<>();
    }
    
    public void displayVaccineList(){
        System.out.println("|    ID    |        Name        |");
        for(Vaccine vaccine : vaccineList){
            vaccine.output();
        }
    }

    @Override
    public void saveFile() {
        try {
           // FileOutputStream fos = new FileOutputStream(v);
            //ObjectOutputStream oos = new ObjectOutputStream(fos);
            FileOutputStream fo = new FileOutputStream(v);
            OutputStreamWriter osw = new OutputStreamWriter(fo, "UTF8");
            FileWriter fw = new FileWriter(v);
            PrintWriter pw=new  PrintWriter(fw);
            vaccineList.add(new Vaccine("Covid-V001", "AstraZeneca"));
            vaccineList.add(new Vaccine("Covid-V002", "SPUTNIK V"));
            vaccineList.add(new Vaccine("Covid-V003", "Vero Cell"));
            vaccineList.add(new Vaccine("Covid-V004", "Pfizer"));
            vaccineList.add(new Vaccine("Covid-V005", "Moderna"));
            for (Vaccine vaccine : vaccineList) {

                pw.println(vaccine.getVaccineId()+","+vaccine.getVaccineName());
                
            }
            fo.close();
            osw.close();       
            fw.close();
            pw.close();
        } catch (Exception e) {
            System.out.println(Color.RED + e.getMessage() + Color.RESET);
        }
    }

    @Override
    public void readFile() {
        try {
            FileInputStream fis = new FileInputStream(v);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Vaccine c = (Vaccine) ois.readObject();
                vaccineList.add(c);
            }
            System.out.println(Color.GREEN + "Read success!!" + Color.RESET);
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println(Color.RED + e.getMessage() + Color.RESET);
        }
    }
}
