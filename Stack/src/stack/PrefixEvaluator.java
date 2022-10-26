/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.Stack;

/**
 *
 * @author PC
 */
public class PrefixEvaluator {
    static boolean isdigit(char ch) {
        if (ch >= 48 && ch <= 57) {
            return true;
        }
        return false;
    }

    static double evaluatePrefix(String exprsn) {
        Stack<Double> stack = new Stack<Double>();

        for (int j = exprsn.length() - 1; j >= 0; j--) {
            if (exprsn.charAt(j) == ' ') {
                continue;
            }
            if (isdigit(exprsn.charAt(j))) {
                double num = 0, i = j;
                while (j < exprsn.length() && isdigit(exprsn.charAt(j))) {
                    j--;
                }
                j++;

                // from [j, i] exprsn contains a number
                for (int k = j; k <= i; k++) {
                    num = num * 10 + (double) (exprsn.charAt(k) - '0');
                }

                stack.push(num);
            } else {

                double o1 = (double) stack.peek();
                stack.pop();
                double o2 = (double) stack.peek();
                stack.pop();

                switch (exprsn.charAt(j)) {
                    case '+':
                        stack.push(o1 + o2);
                        break;
                    case '-':
                        stack.push(o1 - o2);
                        break;
                    case '*':
                        stack.push(o1 * o2);
                        break;
                    case '/':
                        stack.push(o1 / o2);
                        break;
                }
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        String exprsn = "+ 9 * 12 6";
        System.out.print((int) evaluatePrefix(exprsn));
    }
}
