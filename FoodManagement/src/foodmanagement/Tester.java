/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmanagement;


import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Tester {
     public static void main(String[] args) {
        FoodList fl = new FoodList();

        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println(Color.BLUE + "Welcome to Food Management - @ 2021 by < SE151395 - Nguyễn Văn Nam̃ >" + Color.RESET);
        do {
            System.out.println("");
            System.out.println(Color.RED_BACKGROUND + Color.WHITE + "-------------------------------Menu-------------------------------" + Color.RESET);
            System.out.println("Select the options below:");
            System.out.println("1. Add a new food");
            System.out.println("2. Search a food by name");
            System.out.println("3. Remove the food by ID");
            System.out.println("4. Print the food list in the descending order of expired date");
            System.out.println("5. Quit");
            System.out.print("-->Your choice: ");
            choice = Validation.checkInteger(6, "Please choose a function from 1 to 5");

            switch (choice) {
                case 1:
                    do {
                        Food f = new Food();
                        do {
                            f.input();
                            if (fl.findById(f.getId()) != -1) {
                                System.err.println("Id existed! Please input again!");
                            }
                        } while (fl.findById(f.getId()) != -1);

                        if (fl.addFood(f)) {
                            System.out.println(Color.GREEN + "\n Add Successfully \n" + Color.RESET);
                        } else {
                            System.err.println("Add Fail!! Try again");
                        };
//                        fl.displayAll();

                        System.out.println("\nDo you want to continous? (1: yes || 2: no)");
                        System.out.print(">> Your choice: ");
                        int userChoice1 = Validation.checkInteger(2, "Your option is 1 or 2");
                        if (userChoice1 == 2) {
                            break;
                        }
                    } while (true);
                    break;
                case 2:
                    if (fl.checkNull() == true) {
                        System.err.println("Your Refrigerator is EMPTY!!");
                        break;
                    }
                    do {
                        String foodName;
                        System.out.print("Food's name: ");
                        foodName = Validation.checkAnString("Name must be filled");
                        if (fl.searchByName(foodName) == null) {
                            System.err.println("This food does not exist!!");
                        } else {
                            fl.displayByName(foodName);
                        }
                        System.out.println("\nDo you want to continous? (1: yes || 2: no)");
                        System.out.print(">> Your choice: ");
                        int userChoice2 = Validation.checkInteger(2, "Your option is 1 or 2");
                        if (userChoice2 == 2) {
                            break;
                        }
                    } while (true);
                    break;
                case 3:
                    if (fl.checkNull() == true) {
                        System.err.println("Your Refrigerator is EMPTY!!");
                        break;
                    }
                    int confirm;
                    System.out.println("Do you really want to remove some food? (1: yes || 2: no)");
                    System.out.print(">> Your choice: ");
                    confirm = Validation.checkInteger(2, "Your option is 1 or 2");
                    if (confirm == 2) {
                        break;
                    } else {
                        int foodId;
                        System.out.print("Food's Id: ");
                        foodId = Validation.checkInteger(101, "ID not found!! ");
                        if (fl.removeById(foodId) == false) {
                            System.err.println("Remove Fail!!\n");
                        } else {
                            System.out.println(Color.GREEN + "Remove Success!!\n" + Color.RESET);
                            if(fl.checkNull() == true){
                                System.err.println("Your Refrigerator is EMPTY!!\n");
                                break;
                            }
                            fl.displayAll();
                        }
                        break;
                    }
                case 4:
                    if (fl.checkNull() == true) {
                        System.err.println("Your Refrigerator is EMPTY!!");
                        break;
                    }
                    fl.sortDate();
                    break;
                    
                 default:System.err.println("see you again!");
            }
        } while (choice <= 4);             
        
    }
}
