/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queen_problem;

/**
 *
 * @author PC
 */
public class QueenPosition {
    int x,y;
    String value;
    public QueenPosition(int x, int y, String value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
    
    public boolean valdi(QueenPosition p) {
        int dx = this.x-p.x;
        if(dx<0) dx = -dx;
        int dy = this.y-p.y;
        if(dy<0) dy = -dy;
        return (dx != 0 && dy != 0 && dx != dy);
    }
    
    @Override
    public String toString(){
        return "("+x+", "+y+")";
    }
}
