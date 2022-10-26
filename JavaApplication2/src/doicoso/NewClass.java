/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doicoso;

/**
 *
 * @author Nguyen Dinh
 */
public class NewClass {

    private int data;
    private String re = "";

    public NewClass() {
    }

    public NewClass(int data) {
        this.data = data;
    }

    public void printBinary() {
        while (data != 0) {
            if (data % 2 == 0) {
                data = data / 2;
                re = "0" + re;
            } else {
                data = (data - 1) / 2;
                re = "1" + re;
            }
        }
        System.out.println("Binary: " + re);
    }
}
