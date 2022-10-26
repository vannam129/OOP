/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author PC
 */

import controller.InjectionManager;
import controller.StudentManager;
import controller.VaccineManager;
import java.io.IOException;
import java.text.ParseException;
import utilities.MyToys;
public class VaccineManagement {
     /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws ParseException, ClassNotFoundException, IOException, Exception {
        int choice;
        StudentManager studentList = new StudentManager();
        VaccineManager vaccineList = new VaccineManager();
        InjectionManager injectionList = new InjectionManager();
        do {

            printMenu();
            choice = MyToys.getAnInteger("Please choose 1..5: ", "Do you know the limit range(1 - 6) of choose", 1, 6);
            switch (choice) {
                case 1:
                    studentList.print();
                    System.out.println("-------------------------------------------------------------");
                    vaccineList.print();
                    System.out.println("-------------------------------------------------------------");
                    injectionList.print();
                    System.out.println("-------------------------------------------------------------");
                    break;
                case 2:
                    injectionList.addNewInjection();
                    break;
                case 3:
                    injectionList.updateInjection();
                    break;
                case 4:
                    injectionList.removeInjection();
                    break;
                case 5:
                    System.out.println("---------------------------------------------------");
                    injectionList.searchInjection();
                    System.out.println("---------------------------------------------------");
                    break;
                case 6:
                    System.out.println("Bye bye, see you again");
                    injectionList.writeFile();
                    break;
            }
        } while (choice != 6);
    }

    public static void printMenu() {
        System.err.println("Welcome to Covid-19 Vaccine Management - @ 2021 by <SE151395 - Nguyễn Văn Nam>");
        System.out.println("Choose the following functions to play with");
        System.out.println("1. Show Information All Students Have Been Injected");
        System.out.println("2. Add Student's Vaccine Injection Information");
        System.out.println("3. Updating Information Of Students' Vaccine Injection");
        System.out.println("4. Delete Student Vaccine Injection Information");
        System.out.println("5. Search For Injection Information By StudentID");
        System.out.println("6. Quit");
    }
}
