/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class NY {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.err.println("BÉ YÊU ");
        Scanner scanner = new Scanner(System.in);
        String dob = scanner.nextLine();
        System.err.println("Bé YÊU BẠN TÊN LÀ " + dob);
        System.err.println("Va day la CÔ ẤY");          

        FileReader fileReader
                = new FileReader("C:\\Users\\PC\\Documents\\Y.txt");

        BufferedReader buffReader
                = new BufferedReader(fileReader);

        while (buffReader.ready()) {
            System.out.println(
                    buffReader.readLine()
            );
            Thread.sleep(100);
        }
    }

}
