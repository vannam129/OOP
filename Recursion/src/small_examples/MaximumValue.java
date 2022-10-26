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
public class MaximumValue {
    public static double max(double a[], int n){
        if(n==1) return a[0];
        double m = max(a, n-1);
        return m>a[n-1] ? m : a[n-1];
    }
    
    public static void main(String[] args) {
        System.out.println("b[] = { 1, 5, 9, 7, 2, 19,10 }");
        double b[] = { 1, 5, 9, 7, 2, 19,10 };
        System.out.println("max(b, 7)");
        System.out.println(max(b, 7));
    }
}
