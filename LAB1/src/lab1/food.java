/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import static Lab1.booleanDate.toDate;

import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public  class food implements Comparable<food> {

    protected String Id;
    protected String name;
    protected double weight;
    protected int place;
    protected String type;
    protected Date expiredDate;

    public food(String Id) {
        this.Id = Id;
    }

    public food(String Id, String name, double weight, int place, String type, Date expiredDate) {
        this.Id = Id;
        this.name = name;
        this.weight = weight;
        this.place = place;
        this.type = type;
        this.expiredDate = expiredDate;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void inputYourFood() {
        Scanner sc = new Scanner(System.in);
        boolean kiemtra = false;
        do {
            try {
                name = utils.inputString("The name of Food is: ");
                kiemtra = false;
            } catch (Exception e) {
                e.printStackTrace();
                kiemtra = true;
            }
        } while (kiemtra);
        do {
            try {
                weight = utils.inputDouble("The amount of food is: ", 0);
                kiemtra = false;
            } catch (Exception e) {
                e.printStackTrace();
                kiemtra = true;
            }
        } while (kiemtra);
        do {
            try {
                type = utils.inputString("The type of Food is: ");
                kiemtra = false;
            } catch (Exception e) {
                e.printStackTrace();
                kiemtra = true;
            }
        } while (kiemtra);
        do {
            try {
                place = utils.inputInt("Input food place in refrigerator: ", 0);
                kiemtra = false;
            } catch (Exception e) {
                e.printStackTrace();
                kiemtra = true;
            }
        } while (kiemtra);
        do {
            String inputStr = "";
            expiredDate = new Date(System.currentTimeMillis());
            System.out.println("Current Date: " + expiredDate);
            System.out.print("Input a date value yyyy/d/m: ");
            inputStr = sc.nextLine().trim();
            long t = toDate(inputStr);
            if (t < 0) {
                System.out.println("Inputted date is invalid!");
                kiemtra = true;
            } else {
                expiredDate = new Date(t);
                System.out.println("Inputted date: " + expiredDate);
                kiemtra = false;
            }
        } while (kiemtra);
    }

    @Override
    public String toString() {
        return Id + ", " + name + ", " + weight + ", " + type + ", " + place + ", " + expiredDate;
    }

    @Override
    public int compareTo(food t) {
        switch (this.expiredDate.compareTo(t.getExpiredDate())) {
            case 0:
                return 0;
                
            case 1:
                return -1;
              
            default:
                return 1;
             
        }
    }

}
