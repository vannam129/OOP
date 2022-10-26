/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;
import java.util.Scanner;
/**
 *
 * @author Nguyen Dinh
 */
public class Utils {
     public static int getInt(String str) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        boolean check = true;
         
        do {
            try {
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {

            }
        } while (check);
        return result;
    }

    public static int getPositive(String str) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        System.out.println(str);
        do {
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result > 0) {
                    cont = false;
                }
            } catch (NumberFormatException e) {
                    System.out.println("Error! Input number:");
            }
        } while (cont);
        return result;
    
}
        public static String getString(String message) {
                String result = "";
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            System.out.print(message);
            String tmp = sc.nextLine();
            if (!tmp.isEmpty()) {
                result = tmp;
                check = false;
            }
        } while (check);
        return result;
    } 
}
