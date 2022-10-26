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
public class Geometric_Progression {
    public static double gp(int n, double a, double q){
        if(n<1) return 0;
        if(n==1) return a;
        return q*gp(n-1, a, q);
    }
    
    public static void main(String[] args) {
        System.out.println("Test   1.5  3   6  12  24  48");
        System.out.println("gp(6, 1.5, 2)");
        System.out.println("==> "+gp(6, 1.5, 2));
    }
}
