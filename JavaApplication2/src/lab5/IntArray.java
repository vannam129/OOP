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
public class IntArray {
    final private int size;
    private int[] data;
    
    public IntArray() {
        this.size = Utils.getPositive("Input size (Integer): ");
    }

    public IntArray(int size, int[] data) {
        this.size = size;
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    /*public void setSize(int size) {
    this.size = size;
    } */
    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    /* public void enterSize() {
        size = Utils.getPositive("Input size(Integer): ");

    }*/
    public void enterElements() {
        data = new int[size];
        
        for (int i = 0; i < size; i++) {
            System.out.println("data[" + i + "]:");
            data[i] = Utils.getInt("data[" + i + "]: ");
            
        }
    }

    public void softArray() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (data[i] > data[j]) {
                    int c = data[i];
                    data[i] = data[j];
                    data[j] = c;
                }
            }
        }
    }

    public void display(String str) {
        System.out.println(str);
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public int search() {
        int k = Utils.getInt("\nValue: ");
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] == k) {
                count++;
            }
        }
        return count;
    }

    public void searchDisplay(int count) {
        if (count == 0) {
            System.out.println("not found");
        } else {
            System.out.println("Found");
        }
    }
}

