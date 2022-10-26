/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Dinh
 */
import java.util.Scanner;


public class IntArray {

    private int size;
    private int[] data;

    public IntArray() {
    }

    public IntArray(int size, int[] data) {
        this.size = size;
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public int[] getData() {
        return data;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public void enterSize() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input size (Integer):");
        boolean cont = true;
        do {
            try {
                size = Integer.parseInt(sc.nextLine());
                cont = false;
            } catch (NumberFormatException e) {
                System.out.println("Error! Input number:");
            }
        } while (cont);

    }

    public void enterElements() {
        data = new int[size];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            System.out.println("data[" + i + "]:");
            data[i] = sc.nextInt();
        }

    }

    public void displayElements() {
        System.out.print("Array[");
        for (int value : data) {
            System.out.println(value + "");
        }
        System.out.print("]");
    }

    public int findSmallest() {
        int smallest = data[0];
        for (int i : data) {
            if (smallest > i) {
                smallest = i;
            }
        }
        return smallest;
    }

    public float calculateAvg() {
        int avg=0;
        
        for (int value : data) {
            avg += value;
        }
        return avg / size;
    }

    public static void main(String[] args) {
        IntArray array = new IntArray();
        array.enterSize();
        array.enterElements();
        array.displayElements();
        
        int smallest = array.findSmallest();
        System.out.println("");
        System.out.println("smallest:" + smallest);
        
       
    }

    
}
