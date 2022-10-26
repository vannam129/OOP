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
public class SumOfArray {
     public static double sum(double []a, int n){
        if(n==0) return 0;
        return a[n-1]+sum(a, n-1);
    }
    
    public static void main(String[] args) {
        System.out.println("a[] = { 1.5,  2,  4,  5,  2, 6.5 }");
        double a[] = { 1.5,  2,  4,  5,  2, 6.5 };
        System.out.println("sum(a, 6)");
        System.out.println(sum(a, 6));
    }
}
