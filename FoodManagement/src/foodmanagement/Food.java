/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmanagement;

import java.util.Date;
import java.util.Scanner;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Food implements Comparable<Food>, Serializable {

private int id;
    private String name;
    private int weight;
    private String type;
    private String place;
    private Date expiredDate;

    Scanner sc = new Scanner(System.in);
    
    public Food() {
    }

    public Food(int id, String name, int weight, String type, String place, Date expiredDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
    
    public void input(){
        sc = new Scanner(System.in);
        System.out.print("Input ID: ");
        id = Validation.checkInteger(101, "Invalid ID (between 1 to 100)");
        sc = new Scanner(System.in);
        System.out.print("Input name: ");
        name = Validation.checkAnString("Name must be filled");
        sc = new Scanner(System.in);
        System.out.print("Input weight: ");
        weight = Validation.checkInteger(21, "Invalid Weight (< 20kg)");
        sc = new Scanner(System.in);
        System.out.print("Input type: ");
        type = Validation.checkAnString("Type must be filled");
        System.out.print("Input place: ");
        place = Validation.checkAnString("Place must be filled");
//        System.out.print("Input expired date: ");
        expiredDate = Validation.CheckTime("Input expired date: ", "");
    }
    
    public void output(){
//        System.out.println("| ID|      Name      |Weight|   Type   |   Place  |dd/mm/yyyy|");
        System.out.printf("|%3d|%16s|%6d|%10s|%10s|%10s|", id, name, weight, type, place, Validation.convertDateToString(expiredDate));
    }

    @Override
    public int compareTo(Food f) {
        if(getExpiredDate()== null || f.getExpiredDate() == null){
            return 0;
        }
        return f.getExpiredDate().compareTo(getExpiredDate());
    }



}
