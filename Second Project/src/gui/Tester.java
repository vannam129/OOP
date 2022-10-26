/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import data.InjectionList;
import tools.Color;
import tools.Validation;

/**
 *
 * @author PC
 */
public class Tester {

    public static void main(String[] args) {
        InjectionList il = new InjectionList();
        int choice;
        System.out.println(Color.BLUE + "Welcome to Covid-19 Vaccine Management - @ 2021 by < SE151395 - Nguyễn Văn Nam̃ >" + Color.RESET);

        do {
            System.out.println("");
            System.out.println(Color.RED_BACKGROUND + Color.WHITE + "-------------------------------Menu-------------------------------" + Color.RESET);
            System.out.println("Select the options below:");
            System.out.println("1. Show information all students have been injected");
            System.out.println("2. Add student's vaccine injection information");
            System.out.println("3. Updating information of students' vaccine injection");
            System.out.println("4. Delete student vaccine injection information");
            System.out.println("5. Search for injection information by studentID");
            System.out.println("6. Store data");
            System.out.println("7. Quit");
            System.out.print("-->Your choice: ");
            choice = Validation.checkInteger(7, "Please choose a function from 1 to 7");
            switch (choice) {
                case 1:
                    il.displayInjectionList();
                    break;
                case 2:
                    do {
                        il.addNewInjectionInfo();
                        System.out.println("\nDo you want to continous? (1: yes || 2: no)");
                        System.out.print(">> Your choice: ");
                        int userChoice = Validation.checkInteger(2, "Your option is 1 or 2");
                        if (userChoice == 2) {
                            break;
                        }
                    } while (true);
                    break;
                case 3:
                    il.updateInjectionInfo();
                    break;
                case 4:
                    int confirm;
                    do {
                        il.deleteInjection();
                        System.out.println("\nDo you want to continous? (1: yes || 2: no)");
                        System.out.print(">>Your choice: ");
                        confirm = Validation.checkInteger(2, "Your choice must be 1 or 2");
                        if (confirm == 2) {
                            break;
                        }
                    } while (true);
                    break;
                case 5:
//                    String studentId;
//                    System.out.print("Input the Student ID to search : ");
//                    studentId = Validation.checkPattern("^[S]{1}[E]{1}[0-9]{6}$", "Invalid ID --> corect format: SE......");
//                    if (il.searchByStudentId(studentId) == null) {
//                        System.out.println(Color.RED + "Can not find the infomation!!" + Color.RESET);
//                    } else {
//                        il.displayByStudentId(studentId);
//                    }
                    il.searchInjectionByStudentId();
                    break;
                case 6:
                    il.saveFile();
                    System.out.println(Color.GREEN + "Saved!!" + Color.RESET);
                    break;
            }
        } while (choice < 7);
    }
}
