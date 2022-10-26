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
public class Statue extends Item{
    private int weight;
    private String colour;

    public Statue() {
    }

    public Statue(int weight, String colour) {
        this.weight = weight;
        this.colour = colour;
    }


    public Statue(int weight, String colour, int value, String creator) {
        super(value, creator);
        this.weight = weight;
        this.colour = colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
 @Override
    public void inputItem() {
        super.inputItem();
        this.colour = Utils.getString("Colour: ");
        this.weight = Utils.getInt("Weight: ");
    }
    @Override
    public String toString() {
        return super.toString()+","+this.colour+","+this.weight; 
    }

    @Override
    public void updateItem() {
        super.updateItem();
        this.colour = Utils.updateString(this.colour, "Update colour:");
        this.weight = Utils.updateInt(this.weight, "Update weight:");
    }



   
    
}
