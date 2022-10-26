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
import model.Student;
public class WriteStudent {
     private final String filepath = "student.txt";

    public static void main(String[] args) {
        try {
            String fileName = "student.txt";
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            ArrayList<Student> list = new ArrayList<>();
            list.add(new Student("SE15001", "Hoang Chi Cuong"));
            list.add(new Student("SE15002", "Hoang Minh Thuan"));
            list.add(new Student("SE15003", "Ho Dang Khoa"));
            list.add(new Student("SE15004", "Le Quoc Khanh"));
            list.add(new Student("SE15005", "Nguyen Dang Nam"));
            list.add(new Student("SE15006", "Nguyen Huu Phuc "));
            list.add(new Student("SE15007", "Nguyen Huynh Minh Khoi "));
            list.add(new Student("SE15008", "Nguyen Phuoc Tho"));
            list.add(new Student("SE15009", "Nguyen Van Hai Nam"));
            list.add(new Student("SE15010", "Bui Khoi Nguyen"));

            for (Student obj : list) {
                oStream.writeObject(obj);
            }
            oStream.close();
            file.close();
            System.out.println("ok");
        } catch (Exception ex) {
            System.out.println("Failed");
        }
    }

    public ArrayList<Student> readArrayPerObjectFromFile() throws ClassNotFoundException, IOException {
        ArrayList<Student> arr = new ArrayList<>();
        FileInputStream fileIn = null;
        ObjectInputStream objectIn = null;
        try {
            fileIn = new FileInputStream(filepath);
            objectIn = new ObjectInputStream(fileIn);
            Object obj;
            while ((obj = objectIn.readObject()) != null) {
                if (obj instanceof Student) {
                    arr.add((Student) obj);
                }
            }
            objectIn.close();
            fileIn.close();

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

    public void writePerObjectToFile(String filepath, ArrayList<Student> serObj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            try ( ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                for (Student obj : serObj) {
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
