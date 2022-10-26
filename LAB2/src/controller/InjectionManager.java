/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import database.WriteInjection;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import model.Injection;
import utilities.MyToys;

/**
 *
 * @author PC
 */
public class InjectionManager {
     private ArrayList<Injection> injectionList = new ArrayList<>();

    StudentManager studentList;
    VaccineManager vaccineList;

    public InjectionManager() throws ClassNotFoundException, IOException {
        this.readFile();
        this.studentList = new StudentManager();
        this.vaccineList = new VaccineManager();
    }

    public void addNewInjection() throws ParseException {
        do {
            String injectionID;
            Date firstDoesDate;
            String firstDoesPlace;
            Date secondDoesDate = null;
            String secondDoesPlace = null;
            String studentId;
            String vaccineId;
            do {
                injectionID = MyToys.getID("Input Injection ID (IXXX): ", "Invalid Format. Please Input Again",
                        "I[0-9]{3}");
                if (search(injectionID)) {
                    System.out.println("----------------------------------------");
                    System.out.println("The Injection ID Is Existed");
                    System.out.println("----------------------------------------");
                }
            } while (search(injectionID));
            firstDoesDate = MyToys.getDate("Input First Does Date(dd/MM/yyyy): ");
            firstDoesPlace = MyToys.getString("Input The First Does Place: ", "Invalid. Please Input Place Again");

            do {
                studentId = MyToys.getID("Input Student ID(SEXXXXX): ", "Invalid. Please Input Again", "SE[0-9]{5}");
                if (searchStudentInInjectionList(studentId) != false) {
                    System.out.println("----------------------------------------");
                    System.out.println("The Student ID Is Existed.");
                    System.out.println("----------------------------------------");
                } else if (studentList.searchStudentByID(studentId) == false) {
                    System.out.println("----------------------------------------------");
                    System.out.println("The Student ID Is Not Existed In Student List.");
                    System.out.println("----------------------------------------------");
                }
            } while (searchStudentInInjectionList(studentId) != false
                    || studentList.searchStudentByID(studentId) == false);
            do {
                vaccineId = MyToys.getID("Input The Vaccine ID(Covid-VXXX): ", "Invalid. Please Input Again",
                        "Covid-V[0-9]{3}");
                if (vaccineList.searchVaccine(vaccineId) == null) {
                    System.out.println("----------------------------------------");
                    System.out.println("The Vaccine Is Not Existed");
                    System.out.println("----------------------------------------");
                }
            } while (vaccineList.searchVaccine(vaccineId) == null);
            if (MyToys.getAYN("Do You Fill Injection Second?(Y/N): ")) {
                do {
                    secondDoesDate = MyToys.getDate("Input Second Date(dd/MM/yyyy): ");
                    if (computeBetweenInjection(firstDoesDate, secondDoesDate) != true) {
                        System.out.println(
                                "The Second Dose Of Vaccine Must Be Given 4 To 12 Weeks After The First Injection");
                    }
                } while (computeBetweenInjection(firstDoesDate, secondDoesDate) != true);
                secondDoesPlace = MyToys.getString("Input The Second Place: ", "Invalid. Please Input Place Again");
                injectionList.add(new Injection(injectionID, studentList.searchStudent(studentId),
                        vaccineList.searchVaccine(vaccineId), firstDoesDate, firstDoesPlace, secondDoesDate,
                        secondDoesPlace));
                System.out.println("--------------------------------------------");
                System.out.println("|                   Added                  |");
                System.out.println("--------------------------------------------");
            } else {
                secondDoesPlace = null;
                secondDoesDate = null;
                injectionList.add(new Injection(injectionID, studentList.searchStudent(studentId),
                        vaccineList.searchVaccine(vaccineId), firstDoesDate, firstDoesPlace, secondDoesDate,
                        secondDoesPlace));
                System.out.println("--------------------------------------------");
                System.out.println("|                   Added                   |");
                System.out.println("--------------------------------------------");
            }
        } while (MyToys.getAYN(""));
    }

    private void readFile() throws ClassNotFoundException, IOException {
        WriteInjection injection = new WriteInjection();
        this.injectionList = injection.readArrayPerObjectFromFile();
    }

    public void print() {
        if (injectionList.isEmpty()) {
            System.out.println("The List Is Empty");
        } else {
            for (int i = 0; i < injectionList.size(); i++) {
                injectionList.get(i).output();
            }
        }

    }

    private boolean searchStudentInInjectionList(String studentID) {
        int size = injectionList.size();
        for (int i = 0; i < size; i++) {
            if (studentID.equals(injectionList.get(i).getStudent().getStudentID())) {
                return true;
            }
        }
        return false;
    }

    private Injection searchInjectionByStudentId(String studentID) {
        int size = injectionList.size();
        for (int i = 0; i < size; i++) {
            if (studentID.equals(injectionList.get(i).getStudent().getStudentID())) {
                return injectionList.get(i);
            }
        }
        return null;
    }

    public void writeFile() {
        if (injectionList.isEmpty()) {
            System.out.println("The List Is Empty");
        } else {
            WriteInjection injection = new WriteInjection();
            injection.writePerObjectToFile("injection1.txt", injectionList);
        }

    }

    private boolean search(String injectionID) {
        return searchInjection(injectionID) >= 0;
    }

    // ham nay de searchID cua mui tiem co nam trong danh sach muoi tiem khong
    private int searchInjection(String injectionID) {
        for (int i = 0; i < injectionList.size(); i++) {
            if (injectionID.equals(injectionList.get(i).getInjectionID())) {
                return i;
            }
        }
        return -1;
    }

    public void removeInjection() {
        String id;
        int pos;
        String rm;
        id = MyToys.getString("Input INJECTION ID: ", "INJECTION ID Is Required!");
        pos = searchIdByID(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            rm = MyToys.getID("Do You Sure To Remove(Y/N): ", "Invalid Value! Enter again", "[yn|YN]"); // MyToys, in ra
                                                                                                        // dòng thông
                                                                                                        // báo
            if (rm.compareTo("Y") == 0 || rm.compareTo("y") == 0) { // Người dùng nhập Y/y thì sẽ tiếp tục Remove ngược
                                                                    // lại thì không
                injectionList.remove(pos);
                System.out.println("--------------------------------------------");
                System.out.println("The Selected INJECTION Is Removed Successfully!");
                System.out.println("--------------------------------------------");
            } else {
                System.out.println("--------------------------------------------");
                System.out.println("The Selected INJECTION Is NOT Removed!!!");
                System.out.println("--------------------------------------------");
            }
        }
    }

    public int searchIdByID(String injectionID) {

        if (injectionList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < injectionList.size(); i++) {
            if (injectionList.get(i).getInjectionID().equalsIgnoreCase(injectionID)) {
                return i;
            }
        }

        return -1;
    }

    public void searchInjection() {
        if (injectionList.isEmpty()) {
            System.out.println("------------------------------------------------");
            System.out.println("The List Is Empty");
            System.out.println("------------------------------------------------");
        } else {
            int count = 0;
            String studentID;

            studentID = MyToys.getID("Input Student ID(SEXXXXX): ", "Invalid. Please Input Again", "SE[0-9]{5}");
            if (searchStudentInInjectionList(studentID)) {
                searchInjectionByStudentId(studentID).output();
                System.out.println("---------------------------------------------------");
                System.out.println("Searched Successfully");
            } else {
                System.out.println("---------------------------------------------------");
                System.out.println("The Id Is Not Existed");
            }
        }
    }

    public void updateInjection() throws ParseException {
        if (injectionList.isEmpty()) {
            System.out.println("------------------------------------------------");
            System.out.println("The List Is Empty");
            System.out.println("------------------------------------------------");
        } else {
            String injectionID;
            injectionID = MyToys.getID("Input Injection ID (IXXX): ", "Invalid. Please Input Again", "I[0-9]{3}");
            if (search(injectionID)) {

                Date firstDoesDate = injectionList.get(searchInjection(injectionID)).getFirstDoesDate();
                Injection injection = injectionList.get(searchInjection(injectionID));
                if (injectionList.get(searchInjection(injectionID)).getFirstDoesDate() != null) {
                    if (injectionList.get(searchInjection(injectionID)).getSecondDoesDate() == null) {
                        Date secondDoesDate;
                        do {
                            secondDoesDate = MyToys.getDate("Input Second Date(dd/MM/yyyy): ");
                            if (!computeBetweenInjection(firstDoesDate, secondDoesDate)) {
                                System.out.println(
                                        "The Second Dose Of Vaccine Must Be Given 4 To 12 Weeks After The First Injection");
                            }
                        } while (!computeBetweenInjection(firstDoesDate, secondDoesDate));
                        injection.setSecondDoesDate(secondDoesDate);
                        String secondDoesPlace = MyToys.getString("Input Second Place: ",
                                "Invalid. Please input place again");
                        injection.setSecondDoesPlace(secondDoesPlace);
                        System.out.println("------------------------------------------------");
                        System.out.println("Update Successfully");
                        System.out.println("------------------------------------------------");
                    } else {
                        System.out.println("------------------------------------------------");
                        System.out.println("Two Dose Injected");
                        System.out.println("------------------------------------------------");
                    }
                } else {
                    System.out.println("------------------------------------------------");
                    System.out.println("First Dose Hasn't Got Information");
                    System.out.println("------------------------------------------------");
                }

            } else {
                System.out.println("------------------------------------------------");
                System.out.println("The Injection ID Is Not Existed");
                System.out.println("------------------------------------------------");
            }
        }
    }

    private boolean computeBetweenInjection(Date injectionOneDate, Date injectionTwoDate) throws ParseException {
        double interval;
        interval = ((double) (injectionTwoDate.getTime() - injectionOneDate.getTime()) / (1000 * 3600 * 24 * 7));
        if (interval >= 4.0 && interval <= 12.0) {
            return true;
        } 
        return false;
    }
}
