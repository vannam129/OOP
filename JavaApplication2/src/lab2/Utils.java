/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author Nguyen Dinh
 */
public class Utils {
     public static String getPhone() {
        String ph = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("in put phone:");
            ph = sc.nextLine();
            Pattern p = Pattern.compile("^[0-9]{10}$");
            if (p.matcher(ph).find()) {

                break;
            } else {
                System.err.println("phone is not oke");
            }
        }
        return ph;
    }

    public static String getDate() {
        String dateOfBirth = "";
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("in put date of birth:");
            dateOfBirth = sc.nextLine();
            Pattern p = Pattern.compile("^[0-9]+(\\/[0-9]+)(\\/[0-9]+)+$");
            if (p.matcher(dateOfBirth).find()) {

                break;
            } else {
                System.err.println("invalid date,again");
            }
        }
        return dateOfBirth;
    }

    public static String getMail() {
        String email = "";
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("in put mail:");
            email = sc.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$");
            if (p.matcher(email).find()) {

                break;
            } else {
                System.err.println("example:aa/bb/cc,pleas input again");
            }
        }
        return email;
    }

}
