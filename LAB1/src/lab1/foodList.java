/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class foodList {
  ArrayList<food> list = new ArrayList<>();
    boolean check = true;

    public food search(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                return list.get(i);
            }
        }
        return null;
    }

    public boolean isCodeDuplicated(String id) {
        return search(id) != null;
    }

    public void add() {
        String inputId = "";
        boolean kiemtra = false;
        boolean cont = false;
        do {
            do {
                do {
                    try {
                        inputId = utils.inputString("ID of food is: ");
                        kiemtra = false;
                    } catch (Exception e) {
                        e.printStackTrace();
                        kiemtra = true;
                    }
                } while (kiemtra);
                if (isCodeDuplicated(inputId) == true) {
                    System.out.println("Duplicated ID, please input again!");
                }
            } while (isCodeDuplicated(inputId));
            food f = new food(inputId) {};
            f.inputYourFood();
            list.add(f);
            System.out.println("Food Added!");
            cont = utils.inputBoolean("Continue adding food?(Y/N): ");
        } while (cont == true);
    }

    public void research() {
        Scanner sc = new Scanner(System.in);
        String inputName = "";
        boolean kiemtra = false;
        int Count = 0;
        do {
            System.out.println("The name of food you want to search: ");
            inputName = sc.nextLine();
            for (food f : list) {
                if (f.getName().indexOf(inputName) >= 0) {
                    System.out.println("Founded!" + f);
                }
                Count++;
            }
            if (Count == 0) {
                System.out.println("This food is invalid!");
            }
            kiemtra = utils.inputBoolean("Continue Searching food?(Y/N): ");
        } while (kiemtra == true);
    }

    public void removeFood() {
        Scanner sc = new Scanner(System.in);
        String inputId = "";
        boolean confirm = false;
        System.out.println("Input food id to remove:");
        inputId = sc.nextLine();
        food f = search(inputId);
        if (f == null) {
            System.out.println("This food does not exist");
        } else {
            confirm = utils.inputBoolean("Do you want to remove?(Y/N):");
            if (confirm == true) {
                list.remove(f);
                System.out.println("This food removed success!");
            } else {
                System.out.println("This Food removed fail");
            }
        }
    }

    public void showFoodListDescending() {
        for (food f : list) {
            if (f instanceof food) {
                System.out.println("FoodList: " + f.toString());
            }
        }
    }

    public void storeFoodListInTextFile() {
        String filename = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Input filename to save: ");
        filename = sc.nextLine();
        try {
            utils.writeDate(list, filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public boolean readFile(String url) throws FileNotFoundException, IOException {
        File f = new File(url);
        FileReader fr = new FileReader(f);
        boolean check = false;
        BufferedReader br = new BufferedReader(fr);
        try {
            String line = "";
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                String[] str = line.split(", ");
                long d = booleanDate.toDate(str[5]);
             
                Date date = new Date(d);
                list.add(new food(str[0], str[1], Double.parseDouble(str[2]), Integer.parseInt(str[3]), str[4], date));
               
            }if(!list.isEmpty()){
                check=true;
            }
                
            
        } catch (Exception e) {
            
        } finally {
            if (br != null) {
                br.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
        return check;
    }
    
    public void loadFile() throws IOException {
        
        boolean check = readFile("n.txt");
        if (check) {
            System.out.println("Success!!");
            
        } else {
            System.out.println("Error!!");
        }
    }


    public void soft(){
        Collections.sort(list);
    }
    
}


