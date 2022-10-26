/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author PC
 */
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Vaccine;
public class WriteVaccine {
     private final String filepath = "vaccine.txt";

    public static void main(String[] args) {
        try {
            String fileName = "vaccine.txt";
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            ArrayList<Vaccine> list = new ArrayList<>();
            list.add(new Vaccine("Covid-V001", "AstraZeneca"));
            list.add(new Vaccine("Covid-V002", "SPUTNIK V"));
            list.add(new Vaccine("Covid-V003", "Vero Cell"));
            list.add(new Vaccine("Covid-V004", "Pfizer"));
            list.add(new Vaccine("Covid-V005", "Moderna"));
            list.add(new Vaccine("Covid-V006", "Janssen"));
            list.add(new Vaccine("Covid-V007", "CoviVac"));
            list.add(new Vaccine("Covid-V008", "CoronaVac"));
            list.add(new Vaccine("Covid-V009", "Abdala"));
            list.add(new Vaccine("Covid-V010", "Sputnik Light"));
            for (Vaccine obj : list) {
                oStream.writeObject(obj);
            }
            oStream.close();
            file.close();
            System.out.println("The object was written successfully");
        } catch (Exception ex) {
            System.out.println("Failed");
        }
    }

    public ArrayList<Vaccine> readArrayPerObjectFromFile() throws ClassNotFoundException, IOException {
        ArrayList<Vaccine> arr = new ArrayList<>();
        FileInputStream fileIn = null;
        ObjectInputStream objectIn = null;
        try {
            fileIn = new FileInputStream(filepath);
            objectIn = new ObjectInputStream(fileIn);
            Object obj;
            while ((obj = objectIn.readObject()) != null) {
                if (obj instanceof Vaccine) {
                    arr.add((Vaccine) obj);
                }
            }
            objectIn.close();
            fileIn.close();
            System.out.println("The Object was succesfully reading from a file");
        } catch (EOFException eof) {

        } catch (IOException ex) {

        } finally {
            if (objectIn == null) {
                objectIn.close();
            }
            if (fileIn == null) {
                fileIn.close();
            }
        }
        return arr;
    }

    public void writePerObjectToFile(String filepath, ArrayList<Vaccine> serObj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            try ( ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                for (Vaccine obj : serObj) {
                    objectOut.writeObject(obj);
                }
                objectOut.close();
            }
            System.out.println("The Object  was succesfully written to a file");
            fileOut.close();
        } catch (IOException ex) {
            System.out.println("Fail to write object to file" + ex.getMessage());
        }
    }
}
