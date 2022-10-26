/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Date;
import tools.Validation;

/**
 *
 * @author PC
 */
public class Injection implements Serializable{
    private int injectionId;
    private String firstPlace;
    private String secondPlace;
    private Date firstDate;
    private Date secondDate;
    private String studentId;
    private String vaccineId;

    public Injection() {
    }

    public Injection(int injectionId, String firstPlace, String secondPlace, Date firstDate, Date secondDate, String studentId, String vaccineId) {
        this.injectionId = injectionId;
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
        this.firstDate = firstDate;
        this.secondDate = secondDate;
        this.studentId = studentId;
        this.vaccineId = vaccineId;
    }

    public int getInjectionId() {
        return injectionId;
    }

    public void setInjectionId(int injectionId) {
        this.injectionId = injectionId;
    }

    public String getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(String firstPlace) {
        this.firstPlace = firstPlace;
    }

    public String getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(String secondPlace) {
        this.secondPlace = secondPlace;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getSecondDate() {
        return secondDate;
    }

    public void setSecondDate(Date secondDate) {
        this.secondDate = secondDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

//    public void input() {
//        System.out.print("Injection ID : ");
//        injectionId = Validation.checkInteger(100, "ID must between 1 to 100");
//        System.out.print("Injection 1st place : ");
//        firstPlace = Validation.checkAnString("1st place must be filled!!");
//        System.out.print("Injection 2nd place : ");
//        secondPlace = Validation.checkAnString("2nd place must be filled!!");
//        System.out.print("Injection 1st date : ");
//        firstDate = Validation.CheckTime("");
//        System.out.print("Injection 2nd date : ");
//        secondDate = Validation.CheckTime("");
//        System.out.print("Student ID : ");
//        studentId = Validation.checkPattern("^[S]{1}[E]{1}\\d{6}$", "Invalid ID --> corect format: SE......");
//        System.out.print("Vaccine ID : ");
//        vaccineId = Validation.checkPattern("^[C]{1}[o]{1}[v]{1}[i]{1}[d]{1}[-]{1}[A-Z]{1}[0-9]{3}$", "Invalid format!!");
//    }
    
    public void output() {
//        System.out.println("| ID|     1st place      |      2nd place     | 1st date | 2nd date |Student ID|Vaccine ID|");
        System.out.printf("|%3d|%-20s|%-20s|%-12s|%-12s|%-10s|%-12s|", 
                injectionId, firstPlace, secondPlace, Validation.convertDateToString(firstDate), 
                Validation.convertDateToString(secondDate), studentId, vaccineId);
    }
}
