/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;




import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class RefrigeratorManagement {

    public static void main(String[] args) throws IOException {
        ArrayList<String> strList = new ArrayList();
        System.out.println("Welcome to Food Management - @ 2021 by <SE151395 - Nguyễn Văn Nam>");
        System.out.println("Choose the following functions to play with");
        strList.add("Operation 1: Add a new Food");
        strList.add("Operation 2: Search food by name");
        strList.add("Operation 3: Remove food");
        strList.add("Operation 4: Print food list in descending order");
        strList.add("Operation 5: Store food list in file");
        strList.add("Operation 6: Quit!");
        menu menu = new menu();
        int Choice = 0;
        foodList list = new foodList();
        do {
            Choice = menu.getIntChoice(strList);
            System.out.println("You Choose: " + Choice);
            switch (Choice) {
                case 1:
                    list.add();
                    break;
                case 2:
                    list.research();
                    break;
                case 3:
                    list.removeFood();
                    break;
                case 4:
                    list.loadFile();
                    list.soft();
                    
                    list.showFoodListDescending();
                  
                    
                    break;
                case 5:
                    list.storeFoodListInTextFile();
                    break;
                default:
                    System.err.println("QUIT PROGRAM");
            }
        } while (Choice > 0 && Choice < 6);
    }

}
