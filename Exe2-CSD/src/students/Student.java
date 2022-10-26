/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Student implements Comparable{
    String ID="";
    String name ="";
    String mark="";
    Scanner sc =new Scanner(System.in);

    public Student(String ID) {
        this.ID=ID;

     
    }
    public Student(String ID,String name,String mark){
        this.ID=ID;
        this.name=name;
        this.mark=mark;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    


    @Override
    public int compareTo(Object t) {
        return ID.compareTo(((Student)t).ID);
        
    }

    @Override
    public String toString() {
        return ID+","+name+","+mark;
    }

    
}
