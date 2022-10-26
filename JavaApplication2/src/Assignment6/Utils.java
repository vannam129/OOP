/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;
import java.util.Scanner;
/**
 *
 * @author Nguyen Dinh
 */
public class Utils {
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

    public static int getInt(String message) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            try {
                System.out.print(message);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {

            }
        } while (check);
        return result;

    }

    public static String updateString(String oldValue, String message) {
        String result = oldValue;
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;

    }

    public static int updateInt(int oldValue, String message) {
        int result = oldValue;
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            try {
                System.out.print(message);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {

            }
        } while (check);
        return result;

    }

    public static boolean getBoolean(String message) {
        boolean result = true;
        Scanner sc = new Scanner(System.in);
        String choice;
        boolean check = true;
        do {

            System.out.print(message);
            
            do {System.out.println("Do you want:");
                System.out.println("(Y/N): ");
                choice = sc.nextLine();
            } while (!(choice.equals("Y") || choice.equals("N")));
            result = choice.equals("Y");
            //result = Boolean.parseBoolean(sc.nextLine());
            check = false;

        } while (check);
        return result;
    }

    public static boolean updateBoolean(boolean oldValue, String message) {
        boolean result = oldValue;
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        String choice;
        do {
            System.out.print(message);
            //Nhap  True/False
            do {
                System.out.println("Do you want:");
                System.out.println("(Y/N): ");
                choice = sc.nextLine();
            } while (!(choice.equals("Y") || choice.equals("N")));
            result = choice.equals("Y");
            //result = Boolean.parseBoolean(sc.nextLine());
            check = false;

        } while (check);
        return result;

    }
    
    public static void printMenu(){
      
        System.out.println("1. Add new Vase:");
        System.out.println("2. Add new Statue:");
        System.out.println("3. Add new Painting:");
        System.out.println("4. Update Item:");
        System.out.println("5. Remove Item");
        System.out.println("6. Display Vase:");
        System.out.println("7. Display Statue:");
        System.out.println("8. Display Painting:");
        System.out.println("9. Display All Item:");
        
    }
}
