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
public class Menu extends ArrayList<String>{
    public int getUserChoice(){
        int choice=0;
        boolean cont=true;
        do{
            System.out.println("Menu choose:");
            for(int i=0;i<this.size();i++){
                System.out.println((i+1)+"."+this.get(i));
                
            }
            System.out.print("your choice:");
            Scanner sc =new Scanner(System.in);
            try{
                                choice=sc.nextInt();
                if(choice<1||choice>this.size())
                    throw new Exception();
                cont=false;
            }catch(Exception e){
                System.out.println("please enter integer between 1 and "+this.size());
                cont=true;
            }
        }while(cont);
      
    
        return choice;
    }
}
