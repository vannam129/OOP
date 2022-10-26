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
public class ItemManagement {

    private Item[] list;
    private int numOfItem;
    final int MAX = 100;
    private Object[] currentIndex;

    public ItemManagement() {
        this.list = new Item[MAX];
        numOfItem = 0;
    }

    public ItemManagement(Item[] list, int numOfItem) {
        this.list = list;
        this.numOfItem = numOfItem;
    }

    public Item[] getList() {
        return list;
    }

    public void setList(Item[] list) {
        this.list = list;
    }

    public int getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(int numOfItem) {
        this.numOfItem = numOfItem;
    }
    

    public boolean addItem(Item item) {
        boolean result = false;
        try {
            if (this.list != null && numOfItem < MAX) {
                this.list[numOfItem++] = item;
                result = true;
            }
        } catch (Exception e) {
        }
        return result;
    }

    public Item findItem(String creator){
        for(int i=0; i< numOfItem; i++)
        if( list[i].getCreator().equals(creator))
        return list[i];
        return null;
 }
public void displayAll(){
     for (int i = 0; i < numOfItem; i++) {
            System.out.println(list[i].toString());
        }
    }
    public Item findItemByCreator(String creator) {
        Item result = null;
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getCreator().equals(creator)) {
                result = list[i];
                break;
            }
        }

        return result;
    }
 public boolean updateItem(int index) {
        boolean result = false;
        if (index >= 0 && index < numOfItem) {
            list[index].updateItem();
            result = true;
        }
        return result;
    }
 public boolean removeItem(int index) {
        boolean result = false;
        if (index >= 0 && index < numOfItem) {
            for (int i = index; i < numOfItem; i++) {
                list[i] = list[i + 1];
            }
            numOfItem--;
        }
        return result;
    }
 public void displayVase() {
        System.out.println("Vase List: ");
        for (int i = 0; i < numOfItem; i++) {
            if (list[i] instanceof Vase) {
                System.out.println(list[i].toString());
            }

        }
    }

    public void displayStatue() {
        System.out.println("Statue List: ");
        for (int i = 0; i < numOfItem; i++) {
            if (list[i] instanceof Statue) {
                System.out.println(list[i].toString());
            }

        }
    }

    public void displayPainting() {
        System.out.println("Painting List: ");
        for (int i = 0; i < numOfItem; i++) {
            if (list[i] instanceof Painting) {
                System.out.println(list[i].toString());
            }

        }
    }

public void softItems(){
    for(int i=0; i< numOfItem; i++)
    for(int j=numOfItem-1; j>i ;j--){
    if( list[i].getValue()< list[j-1].getValue()){
    Item tmp=list[j];
    list[j]=list[j-1];
    list[j-1]=tmp;
    }
    }
    }
    public void softItemByValue() {
        for (int i = 0; i < numOfItem - 1; i++) {
            for (int j = i; j < numOfItem; j++) {
                if (list[i].getValue() > list[j].getValue()) {
                    Item tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                }
            }
        }
    }
 
}

