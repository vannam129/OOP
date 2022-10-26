/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_gen;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author PC
 */
public class BackTrackGenerator {
        protected int noOfset = 0;
    ArrayList<IntMinMaxSet> iDomains = new ArrayList();
    Configuration curConfig = new Configuration();
    boolean initiated = false;

    public void addDomain(int min, int max) {
        IntMinMaxSet aSet = new IntMinMaxSet(min, max);
        iDomains.add(aSet);
        noOfset++;
    }
    
    public void addDomain(Collection list) {
        IntMinMaxSet aSet = new IntMinMaxSet(list);
        iDomains.add(aSet);
        noOfset++;
    }
    
    public void initiated() {
        curConfig.clear();
        for (int i = 0; i < noOfset; i++) {
            IntMinMaxSet set = iDomains.get(i);
            set.reset();
            curConfig.add(set.nextValue());
        }
        initiated = true;
    }
    
    public void reset() {
        initiated = false;
    }
    
    private boolean isLastConfiguration() {
        for (int i = 0; i < noOfset; i++) {
            if(!iDomains.get(i).isLastValue()) return false;
        }
        return true;
    }
    
    private Configuration copyConfiguration() {
        Configuration copy = new Configuration();
        for (int i = 0; i < noOfset; i++) {
            copy.add(curConfig.get(i));
        }
        return copy;
    }
    
    public Configuration getFirstConfiguration() {
        initiated();
        return copyConfiguration();
    }
    
    public Configuration nextConfiguration() {
        if(!initiated && this.isLastConfiguration()) return null;
        
        int lastIndex = noOfset-1;
        while(lastIndex>=0 && iDomains.get(lastIndex).isLastValue())
            lastIndex--;
        
        if(lastIndex==-1) return null;
        
        int nextValue = iDomains.get(lastIndex).nextValue();
        curConfig.update(lastIndex, nextValue);
        
        if(lastIndex>=0) {
            for(int i=lastIndex+1; i<noOfset; i++) {
                IntMinMaxSet set = iDomains.get(i);
                set.reset();
                curConfig.update(i, set.nextValue());
            }
        }
        return copyConfiguration();
    }
}
