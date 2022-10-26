/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Menu extends ArrayList<String>{
     public int getUserChoice() {
        for (int i = 0; i < this.size(); i++) 
            System.out.println((i+1)+"- "+this.get(i));
        System.out.println("0- Quit");
        return Utils.getInt("\nInput choice: ");
    }
}


