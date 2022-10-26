/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

/**
 *
 * @author Nguyen Dinh
 */
public class AntiqueShop {

    public static void main(String[] args) {
        int choice;
        int index;
        boolean check;
        ItemManagement cm = new ItemManagement();
        do {
            Utils.printMenu();
            choice = Utils.getInt("Input your choice: ");

            switch (choice) {

                case 1:
                    Item vase = new Vase();
                    vase.inputItem();
                    check = cm.addItem(vase);
                    if (check) {
                        System.err.println("Vase added!");
                        System.out.println("====================");
                    }
                    break;
                case 2:
                    Item statue = new Statue();
                    statue.inputItem();
                    cm.addItem(statue);
                    System.err.println("Statue added! ");
                    System.out.println("====================");
                    break;
                case 3:
                    Item painting = new Painting();
                    painting.inputItem();
                    cm.addItem(painting);
                    System.err.println("Painting added!");
                    System.out.println("====================");
                    break;
                case 4:
                    index = Utils.getInt("Input the index that you want to update: ");
                    check = cm.updateItem(index);
                    if (check) {
                        System.err.println("Updated:!");
                        System.out.println("====================");
                    } else {
                        System.err.println("Failed:!");
                        System.out.println("====================");
                    }
                    break;
                case 5:
                    index = Utils.getInt("Input the index that you want to remove: ");
                    check = cm.removeItem(index);
                    if (check) {
                        System.err.println("Removed:!");
                        System.out.println("====================");
                    } else {
                        System.err.println("Failed!");
                        System.out.println("====================");
                    }
                    break;

                case 6:
                    cm.displayVase();
                    System.out.println("====================");
                    break;
                case 7:
                    cm.displayStatue();
                    System.out.println("====================");
                    break;
                case 8:
                    cm.displayPainting();
                    System.out.println("====================");
                    break;
                case 9:
                    cm.displayAll();
                    System.out.println("====================");
                    break;
                default:
                    System.err.println("Bye Bye!");
                    System.out.println("====================");
                    break;
            }
        } while (choice != 9);

    }
}
