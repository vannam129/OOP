/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockmng;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Utils {
    public static int getInt(String message) {
        int reInt = 0;
        String reStr = "";
        boolean check = true;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(message + " : ");
            reStr = sc.nextLine();
            try {
                reInt = Integer.parseInt(reStr);
                check = false;
            } catch (NumberFormatException E) {
            }
        } while (check);

        return reInt;
    }

    public static String getStr(String message) {
        System.out.println(message + " : ");
        Scanner cs = new Scanner(System.in);
        return cs.nextLine();
    }
}
