/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package small_examples;

/**
 *
 * @author PC
 */
public class Factorial {
     public static double factorial(int n){
        if(n<2) return 1;
        return n*factorial(n-1);
    }
    
    public static void main(String[] args) {
        System.out.println("factorial(5): "+factorial(5));
    }
}
