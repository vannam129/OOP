/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockmng;

/**
 *
 * @author PC
 */
public class ClockManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Menu m = new Menu();
        m.add("Add new clock");
        m.add("Remove a Clock");
        m.add("Update a clock");
        m.add("List all Clock");
        m.add("List all clock in range");
        m.add("Quit");
        
        ClockList list = new ClockList();
        int userChoice=0;
        do {
            System.out.println("\n");
            userChoice = m.getUserChoice();
            switch(userChoice) {
                case 1 : list.addClock();
                case 2 : list.removeClock();
                case 3 : list.updateClock();
                case 4 : list.print();
                case 5 : list.printPrice();
                default: System.out.println("see you agian!");
            }
        } while(userChoice>0 && userChoice < 6);
    }
    }
    

