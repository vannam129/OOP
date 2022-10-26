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
public class Item {
    protected int value;
    protected String creator;
    public Item(){ value=0; creator=""; }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public void inputItem() {
        
        this.value = Utils.getInt("Value: ");
        this.creator = Utils.getString("Creator: ");
    }

    public void updateItem(){
        System.out.println(" update Item:");
        this.value= Utils.updateInt(this.value,"update value");
        this.creator = Utils.updateString(this.creator, "update Creator:");
    }

    @Override
    public String toString() {
        return this.value+","+this.creator;
    }

}