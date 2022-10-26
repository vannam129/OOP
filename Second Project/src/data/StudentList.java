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
public class StudentList implements FileOperation {

    ArrayList<Student> studentList;
    File s = new File("student.txt");

    public StudentList() {
        studentList = new ArrayList<>();
    }

    public void displayStudentList() {
        System.out.println("|   ID   |          Name           |Status|\n");
        for (Student student : studentList) {
            if (student.getCode() == 0) {
                System.out.printf(Color.RED + "|%8s|%25s|%6d|\n" + Color.RESET, student.getStudentId(), student.getStudentName(), student.getCode());
            } else if (student.getCode() == 1) {
                System.out.printf(Color.YELLOW + "|%8s|%25s|%6d|\n" + Color.RESET, student.getStudentId(), student.getStudentName(), student.getCode());
            } else {
                System.out.printf(Color.GREEN + "|%8s|%25s|%6d|\n" + Color.RESET, student.getStudentId(), student.getStudentName(), student.getCode());
            }
        }
    }

    public Student takeStudent(String id){
        for(Student student : studentList){
            if(student.getStudentId().equalsIgnoreCase(id)){
                return student;
            }
        }
        return null;
    }
    
    //lấy code
    public int takeCode(String id){
        for(Student student : studentList){
            if(student.getStudentId().equalsIgnoreCase(id)){
                return student.getCode();
            }
        }
        return -1;
    }
    
    @Override
    public void saveFile() {
        try {
 //           FileOutputStream fos = new FileOutputStream(s);
 //         ObjectOutputStream oos = new ObjectOutputStream(fos);
            FileOutputStream fo = new FileOutputStream(s);
            OutputStreamWriter osw = new OutputStreamWriter(fo, "UTF8");
            
            FileWriter fw = new FileWriter(s);
            PrintWriter pw=new  PrintWriter(fw);
            if (studentList.isEmpty()) {
                studentList.add(new Student("SE151025", "Minh Sơn", 0));
                studentList.add(new Student("SE151109", "Đức Tiến", 1));
                studentList.add(new Student("SE151395", "Văn Nam", 0));
                studentList.add(new Student("SE151137", "Quang Trung", 0));
                studentList.add(new Student("SE151183", "Hạ Vũ", 0));
                studentList.add(new Student("SE151256", "Hưng Phát", 0));
                studentList.add(new Student("SE150934", "Trọng Nghĩa", 1));
                studentList.add(new Student("SE150790", "Chí Hùnng", 0));
                studentList.add(new Student("SE151125", "Minh Thanh", 0));
                studentList.add(new Student("SE151170", "Thanh Tỷ", 2));
            }
            for (Student student : studentList) {

                pw.println(student.getStudentId()+","+student.getStudentName()+","+student.getCode());
                
            }
            System.out.println(Color.GREEN + "Saved!!" + Color.RESET);
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
            FileInputStream fis = new FileInputStream(s);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Student s = (Student) ois.readObject();
                studentList.add(s);
            }
            System.out.println(Color.GREEN + "Read success!!" + Color.RESET);
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println(Color.RED + e.getMessage() + Color.RESET);
        }
    }

}




    


