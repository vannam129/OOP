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
public class ArithmeticProgression {
     public static double ap(int n, double a, double d){
        if(n<1) return 0;
        if(n==1) return a;
        return d + ap(n-1, a, d);
    }
    
    public static void main(String[] args) {
        System.out.println("Test 1.5   3.5  5.5   7.5   9.5   11.5");
        System.out.println("ap(5, 1.5, 2)");
        System.out.println("==> "+ap(5, 1.5, 2));
    }
}
