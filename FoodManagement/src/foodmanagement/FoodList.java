/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmanagement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author PC
 */
public class FoodList {
    ArrayList<Food> foodList;

    public FoodList() {
        foodList = new ArrayList<>();
    }
    
    public boolean addFood(Food f){
        return foodList.add(f);
    }
    
    public boolean checkNull(){
        return foodList.isEmpty();
    }
    
    public void displayAll(){
//        if(checkNull() == false){
//            System.err.println("Your refrigerator is empty!");
//        }else{
            System.out.println(Color.GREEN_BACKGROUND + Color.WHITE + "===============================REFRIGERATOR===============================" + Color.RESET);
            System.out.println("| ID|      Name      |Weight|   Type   |   Place  |dd/mm/yyyy|");
            for(Food food : foodList){
                food.output();
//            }
            System.out.println("\n");
        }
    }
    
    public int findById(int id){
        for(int i = 0; i < foodList.size(); i++){
            if(foodList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    
    public Food findFood(int id){
        for(Food food : foodList){
            if(food.getId() == id){
                return food;
            }
        }
        return null;
    }
    
    public Food searchByName(String name){
        for(Food food : foodList){
            if(food.getName().contains(name)){
                return food;
            }
        }
        return null;
    }
    
    public void displayByName(String name){
        System.out.println("| ID|      Name      |Weight|   Type   |   Place  |dd/mm/yyyy|");
        for(Food food : foodList){
            if(food.getName().contains(name)){
                food.output();
                System.out.print("\n");
            }
        }
    }
    
    public boolean removeById(int id){
        Food f = findFood(id);
        if(f == null){
            return false;
        }
        return foodList.remove(f);
    }
    
    public void sortDate(){
//        System.out.println("| ID|      Name      |Weight|   Type   |   Place  |dd/mm/yyyy|");
        Collections.sort(foodList);
        displayAll();
    }
    
    public void saveFile(){
        try{
            FileOutputStream fos = new FileOutputStream("food.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Food food : foodList){
                oos.writeObject(food);
            }
            oos.close();
            fos.close();
        }catch(IOException e){
            System.err.println("Storing Food List Fail!!");
        }
    }
}
