/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author Nguyen Dinh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntArray sc = new IntArray();
        sc.enterElements();
        sc.display("Array:");
        sc.softArray();
        sc.display("\nArray after sorted:");
        int count = sc.search();
        sc.searchDisplay(count);
    }
    
}
