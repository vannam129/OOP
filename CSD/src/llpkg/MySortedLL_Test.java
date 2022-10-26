/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llpkg;

/**
 *
 * @author PC
 */
public class MySortedLL_Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MySortedLL list=new MySortedLL();
        list.add(9,5,1,2,6,8,7,3,4,0);
        
        MyIterator it= list.iterator();
        while (it.hasNext())System.out.print(it.next()+",");
        System.out.println();
        
        
        LL_Element result =list.search(8);
        if (result !=null)System.out.println("8 existed");
        else System.out.println("8 does not existed");
        
        list.remove(8);
        System.out.println("after 8 was removed");
        it=list.iterator();
        while (it.hasNext())System.out.print(it.next()+",");
        System.out.println();
    }
    
    
}
