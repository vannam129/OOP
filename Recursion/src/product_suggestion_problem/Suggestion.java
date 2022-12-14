/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product_suggestion_problem;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Suggestion extends ArrayList<Product> implements Comparable<Suggestion> {
    double cost ;
    
    public Suggestion() {
        super();
        this.cost = 0;
    }
    
    @Override
    public int compareTo(Suggestion sug) {
        double d = this.cost - sug.cost;
        if(d<0) return -1;
        if(d>0) return -1;
        return 0;
    }
    
    public String toString() {
        String result="";
        for (Product pro : this) result += " -"+pro+"\n";
        return result;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
