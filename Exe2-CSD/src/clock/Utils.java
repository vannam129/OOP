/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Utils {
     public static int inputInt(String message, int min) throws Exception {
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

    public static double inputDouble(String message, double min) throws Exception {
        double number = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        number = sc.nextDouble();
        if (number <= min) {
            throw new Exception();
        }
        return number;

    }

    public static String inputString(String message) throws Exception {
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

    

    public static boolean inputBoolean(String message) {
        boolean result;
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        str = sc.nextLine().trim().toUpperCase();
        result = str.startsWith("Y");
        System.out.println("result:" + result);
        return result;

    }

    public static void writeDate(ArrayList<Clock> list, String filename) throws Exception {
        try (PrintWriter w = new PrintWriter(filename)) {
            list.forEach((f) -> {
                w.println(f);
            });
        }
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
