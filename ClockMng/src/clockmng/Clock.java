/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockmng;

/**
 *
 * @author PC
 */
public class Clock {
      private String id;
    private String manufact;
    private int price;
    private int quarentee;

    public Clock() {
    }

    public Clock(String id) {
        this.id = id;
    }

    public Clock(String id, String manufact, int price, int quarentee) {
        this.id = id;
        this.manufact = manufact;
        this.price = price;
        this.quarentee = quarentee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuarentee() {
        return quarentee;
    }

    public void setQuarentee(int quarentee) {
        this.quarentee = quarentee;
    }
    
    public void create() {
        id = Utils.getStr("Input id");
        manufact = Utils.getStr("Input manufact");
        price = Utils.getInt("Input price");
        quarentee = Utils.getInt("Input quarentee");
    }
    
    @Override
    public String toString() {
        return "id: " + id + ", manufact: " + manufact + ", price: " + price + ", quarentee: " + quarentee;
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((Clock)obj).getId());
    }


    
}
