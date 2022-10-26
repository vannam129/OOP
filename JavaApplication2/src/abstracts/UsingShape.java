/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstracts;

import interfaces.Rectangle;
import interfaces.Shape;

/**
 *
 * @author Nguyen Dinh
 */
public class UsingShape {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Shape shape = new Rectangle();
        shape.draw();
        
        shape = new interfaces.Circle();
        shape.draw();
        
        ShapeAbstract abs = new Square();
        abs.draw();
        
        
    }
    
}
