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
public class Vase extends Item{
    private int height;
    private String material;

    public Vase() {
    }

    public Vase(int height, String material) {
        this.height = height;
        this.material = material;
    }


    public Vase(int height, String material, int value, String creator) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
 @Override
    public void inputItem() {
        super.inputItem();
        this.height = Utils.getInt("Height: ");
        this.material = Utils.getString("Material: ");
    }
    @Override
    public String toString() {
        return super.toString()+","+this.height+","+this.material; 
    }

    @Override
    public void updateItem() {
        super.updateItem();
        this.height = Utils.updateInt(this.height, "update Hright of Vase:");
        this.material =Utils.updateString(this.material, "update Material of Vase:");
    }



   


    }


   
    

