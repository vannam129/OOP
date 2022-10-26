/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleGrapghs;

import java.util.ArrayList;
import simpleGraph.edge.Edge;
import simpleGraph.edge.Path;
import simpleGraphs.vertex.AdjInfo;
import simpleGraphs.vertex.Vertex;

/**
 *
 * @author PC
 */
public class DJ_SP_Result {
    Vertex start;
    AbstractGraph g;
    ArrayList<Path> paths;
    
    public DJ_SP_Result(AbstractGraph g, Vertex start) {
        this.start = start;
        this.g=g;
        
        paths = new ArrayList(g.size());
        for (int i = 0; i < g.size(); i++) paths.add(new Path());
    }
    
    public String toString() {
        String S="";
        for (int i = 0; i < g.size(); i++) {
            S+= "From"+start.key+" to "+((Vertex)g.get(i)).key
                    +", len:"+paths.get(i).pathLen+": "+paths.get(i)+"\n";
        }
        return S;
    }
        
    public void setupPath(int VertexIndex) {
        Vertex dest = (Vertex)g.get(VertexIndex);
        Path path = paths.get(VertexIndex);
        path.pathLen=dest.pathlen;
        AdjInfo adj;
        Edge e;
        
        Vertex src=dest.predecessor;
        while(src!=null) {
            adj = g.getAdjInfo(src, dest);
            e = new Edge(src, dest, adj.weight);
            path.addFirst(e);
            dest = src;
            src = src.predecessor;
        }
    }
    
    public void setupPath() {
        for (int i = 0; i<g.size(); i++) {
            setupPath(i);
        }
    }
}
