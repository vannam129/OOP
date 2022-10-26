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
public class Student implements Serializable{
    private String studentID;
    private String nameStudent;
    
    
    public Student(String studentID, String nameStudent) {
        this.studentID = studentID;
        this.nameStudent = nameStudent;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }
   
    public void output(){
        System.out.printf("|Student|ID: %-15s|NAME: %-25s|\n", studentID, nameStudent);
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", nameStudent=" + nameStudent + '}';
    }
    
    public String print(){
        return String.format("STUDENTID: %-15s|STUDENTNAME: %-20s", studentID, nameStudent);
    }
}
