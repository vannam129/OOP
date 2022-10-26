/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Clock {
    String ID="";
    String manufacturer="";
    String price="";
    Scanner sc = new Scanner(System.in);
    
    public static Comparator comparator =new Comparator(){
        @Override
        public int compare(Object t, Object t1) {
            return ((Clock)t).ID.compareTo(((Clock)t1).ID);
            
        }
        
    };

    public Clock(String ID) {
        this.ID=ID;
    }

    public Clock(String ID,String manu,String p) {
        this.ID=ID;
        this.manufacturer=manu;
        this.price=p;
        
    }

    public Clock() {
    }



    @Override
    public String toString() {
        return ID+","+manufacturer+","+price;
        
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public static Comparator getComparator() {
        return comparator;
    }

    public static void setComparator(Comparator comparator) {
        Clock.comparator = comparator;
    }
    
      
    
}
