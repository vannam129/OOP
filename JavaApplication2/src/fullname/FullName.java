/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fullname;

import java.util.Scanner;

public class FullName {

    public static void main(String[] args) {
        @SuppressWarnings("UnusedAssignment")
        int a = 0;
        @SuppressWarnings("UnusedAssignment")
        int b = 0;
        @SuppressWarnings("UnusedAssignment")
        int sum = 0;
        String id, name;
        Scanner sc = new Scanner(System.in);
        System.out.print("Student ID: ");
        id = sc.nextLine();
        System.out.print("Full name: ");
        name = sc.nextLine();
        System.out.print("a: ");
        a = sc.nextInt();
        System.out.print("b: ");
        b = sc.nextInt();
        System.out.println("HEY!, " + id + ", " + name);
        sum = a + b;
        System.out.println("Sum: " + sum);
    }
}
