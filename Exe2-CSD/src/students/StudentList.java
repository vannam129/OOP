/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author PC
 */
public class StudentList extends TreeSet<Student>{
    public StudentList(){
        super();
    }
 public Student search(String ID){
     return this.ceiling(new Student(ID));
     
 }  
public void output(){
    Iterator it = this.iterator();
    while(it.hasNext()){
        System.out.println(it.next());
    }

} 
    
}
