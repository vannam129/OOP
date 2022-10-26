/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstracts;



/**
 *
 * @author Nguyen Dinh
 */
public class Circle extends ShapeAbstract {

    @Override
    public void draw() {
       System.out.println("Draw"+getColor()+"Circle");
    }
    
}
