/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PC
 */
import java.io.Serializable;
import java.util.Date;
public class Injection implements Serializable{
    private String injectionID;
    private Student student;
    private Vaccine vaccine;
    private Date firstDoesDate;
    private String firstDoesPlace;
    private Date secondDoesDate;
    private String secondDoesPlace;

    public Injection(String injectionID, Student student, Vaccine vaccine, Date firstDoesDate, String firstDoesPlace,
            Date secondDoesDate, String secondDoesPlace) {
        this.injectionID = injectionID;
        this.student = student;
        this.vaccine = vaccine;
        this.firstDoesDate = firstDoesDate;
        this.firstDoesPlace = firstDoesPlace;
        this.secondDoesDate = secondDoesDate;
        this.secondDoesPlace = secondDoesPlace;
    }

    public String getInjectionID() {
        return injectionID;
    }

    public void setInjectionID(String injectionID) {
        this.injectionID = injectionID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public String getFirstDoesPlace() {
        return firstDoesPlace;
    }

    public void setFirstDoesPlace(String firstDoesPlace) {
        this.firstDoesPlace = firstDoesPlace;
    }

    public Date getFirstDoesDate() {
        return firstDoesDate;
    }

    public void setFirstDoesDate(Date firstDoesDate) {
        this.firstDoesDate = firstDoesDate;
    }

    public Date getSecondDoesDate() {
        return secondDoesDate;
    }

    public void setSecondDoesDate(Date SecondDoesDate) {
        this.secondDoesDate = SecondDoesDate;
    }

    public String getSecondDoesPlace() {
        return secondDoesPlace;
    }

    public void setSecondDoesPlace(String SecondDoesPlace) {
        this.secondDoesPlace = SecondDoesPlace;
    }

    public void output() {
        System.out.printf("|Injection information|ID: %-8s|First Dose Place: %-6s|Second Dose Place: %-6s|%s|%s|",
                injectionID, firstDoesPlace, secondDoesPlace, student.print(), vaccine.print());
        System.out.printf("%1$td.%1$tm.%1$tY", firstDoesDate);
        System.out.printf("|%1$td.%1$tm.%1$tY%n", secondDoesDate);
    }

    @Override
    public String toString() {
        return "Injection{" + "injectionID=" + injectionID + ", student=" + student + ", vaccine=" + vaccine
                + ", firstDoesDate=" + firstDoesDate + ", firstDoesPlace=" + firstDoesPlace + ", secondDoesDate="
                + secondDoesDate + ", SecondDoesPlace=" + secondDoesPlace + '}';
    }
}
