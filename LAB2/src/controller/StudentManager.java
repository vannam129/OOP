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

import database.WriteStudent;
import java.io.IOException;
import java.util.ArrayList;
import model.Student;
public class StudentManager {
     private ArrayList<Student> studentList = new ArrayList<>();

    public StudentManager() throws ClassNotFoundException, IOException {
        readFile();
    }

    public void print() {
        if (studentList.isEmpty()) {
            System.out.println("The list is empty");
        }
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).output();
        }
    }

    //doi public thanh private
    private void readFile() throws ClassNotFoundException, IOException {
        WriteStudent student = new WriteStudent();
        this.studentList = student.readArrayPerObjectFromFile();
    }

    public Student searchStudent(String studentID) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentID.equals(studentList.get(i).getStudentID())) {
                return studentList.get(i);
            }
        }
        return null;
    }

    public boolean searchStudentByID(String studentID) {
        return searchStudent(studentID) != null;
    }
}
