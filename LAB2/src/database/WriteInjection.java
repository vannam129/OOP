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
import model.Injection;
import model.Student;
import model.Vaccine;
public class WriteInjection {
     private final String file = "injection1.txt";

    public static void main(String[] args) {
        try {
            String fileName = "injection1.txt";
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            ArrayList<Injection> list = new ArrayList<>();

            list.add(new Injection("I001", new Student("SE15139", "Nguyễn Văn Nam"),
                    new Vaccine("Covid-V001", "AstraZeneca"), null, "Fpt", null, null));
            list.add(new Injection("I002", new Student("SE15002", "Trần Thiên Phúc"),
                    new Vaccine("Covid-V002", "SPUTNIK V"), null, "Fpt", null, null));
            list.add(new Injection("I003", new Student("SE15003", "Nguyễn Văn A"),
                    new Vaccine("Covid-V002", "AstraZeneca"), null, "Fpt", null, null));
            list.add(new Injection("I004", new Student("SE15004", "Nguyễn Văn B"),
                    new Vaccine("Covid-V002", "AstraZeneca"), null, "Fpt", null, null));

            for (Injection obj : list) {
                oStream.writeObject(obj);
            }
            oStream.close();
            file.close();
            System.out.println("Successfully");
        } catch (Exception ex) {
            System.out.println("Failed");
        }
    }

    public ArrayList<Injection> readArrayPerObjectFromFile() throws ClassNotFoundException, IOException {
        ArrayList<Injection> arr = new ArrayList<>();
        FileInputStream fileIn = null;
        ObjectInputStream objectIn = null;
        try {
            fileIn = new FileInputStream(file);
            objectIn = new ObjectInputStream(fileIn);
            Object obj;
            while ((obj = objectIn.readObject()) != null) {
                if (obj instanceof Injection) {
                    arr.add((Injection) obj);
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

    public void writePerObjectToFile(String file, ArrayList<Injection> serObj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            try ( ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                for (Injection obj : serObj) {
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
