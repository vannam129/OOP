/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_gen;

import java.util.Collection;

/**
 *
 * @author PC
 */
public class IntMinMaxSet {
     private int minValue = 0;
    private int maxValue = 0;
    private int curValue = minValue-1;
    
    public IntMinMaxSet(int min, int max) {
        if(max<min) {
            int t = max;
            max = min;
            min = t;
        }
        this.minValue = min;
        this.maxValue = max;
        this.curValue = minValue - 1; 
    }
    
    public IntMinMaxSet(Collection col) {
        this.minValue = 0;
        this.maxValue = col.size()-1;
        this.curValue = minValue - 1; 
    }
    
    public boolean hasNext() {
        return curValue<maxValue;
    }
    
    public int nextValue() {
        if(this==null) throw new RuntimeException("The set is empty !");
        if(this.isLastValue()) throw new RuntimeException("End of the set !");
        return ++curValue;
    }
    
    public void reset() {
        curValue = minValue-1;
    }
    
    public boolean isLastValue() {
        return curValue==maxValue;
    }
}
