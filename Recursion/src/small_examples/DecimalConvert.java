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
public class DecimalConvert {
        public static String convert(int n, int base){
        if(n==0) return "0";
        return convert(n/base, base) + Character.forDigit(n%base, base);
    }
    
    public static void main(String[] args) {
        int n = 266;
        System.out.println("Convert: "+n);
        System.out.println("Binary: " + convert(n, 2));
        System.out.println("Octal: " + convert(n, 8));
        System.out.println("Decimal: " + convert(n, 10));
        System.out.println("Hexadecimal: " + convert(n, 16));
        
    }
}
