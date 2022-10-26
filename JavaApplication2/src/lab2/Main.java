/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the edito
 */
package lab2;

import java.util.Scanner;

/**
 *
 * @author Nguyen Dinh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String id, name;
        Scanner sc = new Scanner(System.in);
        System.out.print("Student ID: ");
        id = sc.nextLine();
        System.out.print("Full name: ");
        name = sc.nextLine();

        Lab2 array = new Lab2();
        array.phone();
        array.date();
        array.mail();
    }

}
