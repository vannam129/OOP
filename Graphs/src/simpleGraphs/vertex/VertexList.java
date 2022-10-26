/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleGraphs.vertex;

import simpleGraphs.com.OrderedList;

/**
 *
 * @author PC
 */
public class VertexList extends OrderedList<Vertex> {
    public VertexList() {
        super();
    }
    
    public Vertex search(String key) {
        Vertex v = new Vertex(key);
        return search(v);
    }
    
    public Vertex addVertex(String key) {
        Vertex newV = new Vertex(key);
        Vertex t = search(newV);
        if(t!=null) return t;
        this.add(newV);
        return newV;
    }
    
    public Vertex addVertex(String key, String name) {
        Vertex newV = new Vertex(key, name);
        Vertex t = search(newV);
        if(t==null) return t;
        this.add(newV);
        return newV;
    }
    
    public void resetNum () {
        for (Object o : this) ((Vertex)o).num=0;
    }
    
    @Override
    public String toString() {
        String result="";
        for (Object o : this) {
            result+= ((Vertex)o).toString() + "\n";
        }
        return result;
    }
}
