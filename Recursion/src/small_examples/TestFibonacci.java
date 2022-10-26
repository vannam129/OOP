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
public class TestFibonacci {
     public static int fibo(int n) {
        if(n<2) return 1;
        return fibo(n-1) + fibo(n-2);
    }
    
    public static boolean testFibo(int x) {
        System.out.println("\nNumber: "+x);
        if(x<1) return false;
        int n = 2;
        int aFibo = 1;
        while(aFibo<x) {
            aFibo = fibo(++n);
            
        }
        System.out.println(aFibo);
        return x==aFibo;
    }
    
    public static void main(String[] args) {
        System.out.println("Fibo: 1 1 2 3 5 8 13 21 34 55 89 144");
        System.out.println(testFibo(55));
        System.out.println(testFibo(144));
        System.out.println(testFibo(120));
    }
}
