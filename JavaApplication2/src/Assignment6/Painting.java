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
public class Painting  extends Item {
    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;

    public Painting() {
    }

    public Painting(int height, int width, boolean isWatercolour, boolean isFramed) {
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public Painting(int height, int width, boolean isWatercolour, boolean isFramed, int value, String creator) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isIsWatercolour() {
        return isWatercolour;
    }

    public void setIsWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }

    public boolean isIsFramed() {
        return isFramed;
    }

    public void setIsFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }
 @Override
    public void inputItem() {
        super.inputItem();
        this.height = Utils.getInt("Height: ");
        this.width = Utils.getInt("Width: ");
        this.isFramed = Utils.getBoolean("Framed ");
        this.isWatercolour = Utils.getBoolean("Water colour ");
    }
    @Override
    public String toString() {
        return super.toString()+","+this.height+","+this.isFramed+","+this.width+","+this.isWatercolour;
    }

    @Override
    public void updateItem() {
        super.updateItem();
        this.height = Utils.updateInt(this.height, "Update height:");
        this.width = Utils.updateInt(this.width, "Update width:");
       this.isFramed = Utils.updateBoolean(isFramed, "Update isFramed: ");
        this.isWatercolour = Utils.updateBoolean(isWatercolour, "Update isWatercolour: ");
       
    }

   
   
    
}
