/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayList;

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

    public static void printMenu(){
        System.err.println("1.Add Experience");
        System.err.println("2.Add Intern");
        System.err.println("3.Find Candidate by ID");
        System.err.println("4.Find Candidate by Index");
        System.err.println("5.Update by ID");
        System.err.println("6.Update by Index");
        System.err.println("7.Remove by ID");
        System.err.println("8.Remove by Index");
        System.err.println("9.Display Experience");
        System.err.println("10.Display Intern");
        System.err.println("11.Display all");
        System.err.println("QUIT");
    }


}

