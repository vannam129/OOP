/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public static int checkInteger(int range, String error) {
        int a;
        while (true) {
            try {
                a = Integer.parseInt(sc.nextLine());
                if (a <= 0 || a > range) {
                    throw new Exception();
                }
                return a;
            } catch (Exception e1) {
                System.out.println(Color.RED + error + Color.RESET);
            }
        }
    }

    public static String checkAnString(String error) {
        String a;
        while (true) {
            try {
                a = sc.nextLine();
                if (a.equals("")) {
                    throw new Exception();
                }
                return a;
            } catch (Exception e2) {
                System.out.println(Color.RED + error + Color.RESET);
            }
        }
    }

    public static String checkPattern(String pattern, String error) {
        String a;
        while (true) {
            try {
                a = sc.nextLine();
                if (!a.matches(pattern)) {
                    throw new Exception();
                }
                return a;
            } catch (Exception e3) {
                System.out.println(Color.RED + error + Color.RESET);
            }
        }
    }

    public static Date CheckTime(String time) {
        boolean check = true;
        Date now = null;
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        d.setLenient(false);
        do {
            do {
                try {
//                    sc = new Scanner(System.in);
//                    System.out.print(message);
                    time = sc.nextLine();
                    if (!time.matches("^\\d{1,2}[/]\\d{1,2}[/]\\d{4}$")) {
                        throw new Exception();
                    }
                    check = false;
                } catch (Exception e) {
                    System.out.println(Color.RED + "Invalid Time!(DD/MM/YYYY)" + Color.RESET);
                }
            } while (check);
            try {
                now = d.parse(time);
                check = false;
            } catch (ParseException e) {
                System.out.println(Color.RED + "Invalid Time!(The Input'Data not suitable!)" + Color.RESET);;
                check = true;
            }
        } while (check);
        return now;
    }

    public static String convertDateToString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if(date == null){
            return String.format("null", date);
        }
        return df.format(date); 
        
    }
    
    public static Date convertStringToDate(String s) throws ParseException{
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = s; 
        Date dateObject = sdf.parse(dateString);
        return dateObject;
    }
}
