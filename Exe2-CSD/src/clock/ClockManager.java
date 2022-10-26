/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;


import java.util.Scanner;

/**
 *
 * @author PC
 */
public class ClockManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.err.println("Welcome to  - @ 2021 by <SE151395 - Nguyễn Văn Nam>");
        System.err.println("Choose the following functions to play with");

        ClockList list = new ClockList();
        //menu
        Menu menu=new Menu();
        menu.add("add new Clock");
        menu.add("search Clock by ID");
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
                    System.out.print("Enter manufacturer:");
                    sc=new Scanner(System.in);
                    String manufacturer=sc.nextLine();
                    System.out.print("Enter price:");
                    sc=new Scanner(System.in);
                    String price=sc.nextLine();
                    Clock cl =new Clock(ID,manufacturer,price);
                    list.add(cl);
                    System.out.println("Added Success!!");
                    break;
                case 2:
                    System.out.println("Enter ID to search");
                    sc=new Scanner(System.in);
                    ID=sc.nextLine();
                    Clock clo=list.search(ID);
                    if(clo!=null)
                        System.out.println("Found"+clo);
                    else
                        System.out.println("Clock"+ID+"dose not exist");
                    break;
                case 3:
                    list.output();
                    break;
                default:
                    System.out.println("GOOD BYE!!!");
                    
                          
            }
        }while(choice<4);
    

    }
    
}
