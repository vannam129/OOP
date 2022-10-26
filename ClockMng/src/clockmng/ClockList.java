/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockmng;

import java.util.LinkedList;

/**
 *
 * @author PC
 */
public class ClockList extends LinkedList<Clock>{
     public void addClock() {
        Clock cl = new Clock();
        cl.create();
        if(this.indexOf(new Clock(cl.getId()))<0)
            if(this.add(cl)==true)
                System.out.println("Added successfully");
            else 
                System.out.println("Added failed !");
             else 
                System.out.println("Id already exits");
    }
    
    private int search(String id) {
        return this.indexOf(new Clock(id));
    }
    
    public void removeClock() {
        String id = Utils.getStr("Input clock id which will be remove");
        int index = this.search(id);
        if(index>=0) {
            this.remove(index);
            System.out.println("Remove successfully");
        } else {
            System.out.println("Remove fail !");
        }
    }
    
    public void updateClock() {
        String id = Utils.getStr("Input clock id which will be update");
        int index = this.search(id);
        if(index>=0) {
            this.get(index).create();
            System.out.println("Update successfully");
        } else {
            System.out.println("Update fail !");
        }
    }
    
    public void print() {
        for (Clock cl : this) System.out.println(cl.toString());
    }
    
    public void printPrice() {
        System.out.println("Input range price");
        int price1 = Utils.getInt("Price 1");
        int price2 = Utils.getInt("Price 2");
        
        if(price1>price2) {
            int t = price1;
            price1 = price2;
            price2 = t;
        }
        
        for (Clock cl : this) {
            int price = cl.getPrice();
            if(price1<=price && price<=price2) {
                System.out.println(cl.toString());
            }
        }
    }
}
