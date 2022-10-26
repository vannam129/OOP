/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockmng;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Menu extends ArrayList {
     public int getUserChoice()  {
        for(int i=0; i<this.size(); i++) {
            System.out.println((i+1) + "-" + this.get(i));
        }
        return Utils.getInt("Choice option");
    }
}
