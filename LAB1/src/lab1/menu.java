/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class menu {

    public int getIntChoice(ArrayList list) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "-" + list.get(i));
        }
        System.out.println("-------------------------");
        System.out.println("Please choose " + "1..." + list.size() + ":");
        return Integer.parseInt(sc.nextLine());
    }
}
