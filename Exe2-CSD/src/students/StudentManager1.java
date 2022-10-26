/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students;

import java.util.ArrayList;
import java.util.Scanner;




/**
 *
 * @author PC
 */
public class StudentManager1 {
    public static void main (String[] args){

        System.err.println("Welcome to  - @ 2021 by <SE151395 - Nguyễn Văn Nam>");
        System.err.println("Choose the following functions to play with");

         StudentList list = new StudentList();
        //menu
        Menu menu=new Menu();
        menu.add("add new Student");
        menu.add("search Student by ID");
        menu.add("output");
        menu.add("quit");
        int choice;
        do{
            choice =menu.getUserChoice();
            Scanner sc=new Scanner(System.in);
            switch(choice){
                case 1:
                    System.out.print("Enter ID:");
                    sc=new Scanner(System.in);
                    String ID=sc.nextLine();
                    System.out.print("Enter name:");
                    sc=new Scanner(System.in);
                    String name=sc.nextLine();
                    System.out.print("Enter mark:");
                    sc=new Scanner(System.in);
                    String mark=sc.nextLine();
                    Student st =new Student(ID,name,mark);
                    list.add(st);
                    System.out.println("Added Success!!");
                    break;
                case 2:
                    System.out.println("Enter ID to search");
                    sc=new Scanner(System.in);
                    ID=sc.nextLine();
                    Student std=list.search(ID);
                    if(std!=null)
                        System.out.println("Found"+std);
                    else
                        System.out.println("Student"+ID+"dose not exist");
                    break;
                case 3:
                    list.output();
                    break;
                case 4:
                    System.out.println("GOOD BYE!!!");
                    break;
                    
                    
                          
            }
        }while(choice<4);
    
      /*  StudentList list =new StudentList();
        //add 5 student
        Student st = new  Student("SE009","Nam",4);
        list.add(st);
        st=new Student ("SE001","Phuc",7);
        list.add(st);
        st=new Student ("SE006","Vinh",8);
        list.add(st);
        st=new Student ("SE002","Truong",9);
        list.add(st);
        st=new Student ("SE005","Dat",2);
        list.add(st);
        //output
        list.output();
        //search not
        String ID="SE003";
        st=list.search(ID);
        if(st==null || !st.getID().equals(ID))
           System.out.println("Student"+ID+"does not exist");
        else System.out.println("Found"+st);
        
        //search
        ID="SE006";
        st=list.search(ID);
        if(st==null || !st.getID().equals(ID))
           System.out.println("Student"+ID+"does not exist");
        else System.out.println("Found"+st);
        */

}
        
    }

