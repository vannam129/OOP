/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author PC
 */
public class IntBstDemo {
    public static void main(String[] args) {
        Menu mnu = new Menu();
        mnu.add("Add new key");
        mnu.add("Maximum value");
        mnu.add("Minimum value");
        mnu.add("Average value");
        mnu.add("Tree's height");
        mnu.add("Breadth-first output");
        mnu.add("Align output");
        mnu.add("Preoder output");
        mnu.add("Inorder-LNR output");
        mnu.add("Inorder-RNL output");
        mnu.add("Postorder output");
        mnu.add("Searching a key");
        mnu.add("Removing a key-By merging");
        mnu.add("Removing a key-By copying");
        
        IntBstTree tree = new IntBstTree();
        tree.add(32,11,57,6,18,40,80,2,8,16,22,35,50,70,90);
        tree.add(1,5,10,15,17,34,37,45,85,3);
        int choice;
        int x;
        do {
            System.out.println("\n____ MENU ____");
            choice = mnu.getUserChoice();
            switch(choice) {
                case 1: {
                    x = Utils.getInt("Input a key");
                    if(tree.add(x)==true)
                        System.out.println("Adding "+x+" successfully");
                    else 
                        System.out.println("Adding failed");
                    break;
                }
                case 2: {
                    System.out.println("Max value: "+tree.getMax());
                    break;
                }
                case 3: {
                    System.out.println("Min value: "+tree.getMin());
                    break;
                }
                case 4: {
                    System.out.println("Average value: "+tree.getAverage());
                    break;
                }
                case 5: {
                    System.out.println("Tree's height: "+tree.getHeight());
                    break;
                }
                case 6: {
                    System.out.println("Breadth-first/level-based output: ");
                    tree.printLevelBased();
                    break;
                }
                case 7: {
                    System.out.println("Tree in aligned format: ");
                    tree.printAlign();
                    break;
                }
                case 8: {
                    System.out.println("Tree in preorder list: ");
                    tree.printNLR();
                    break;
                }
                case 9: {
                    System.out.println("Inorder-LNR output");
                    tree.printLNR();
                    break;
                }
                case 10: {
                    System.out.println("Inorder-RNL output");
                    tree.printRNL();
                    break;
                }
                case 11: {
                    System.out.println("Postorder output");
                    tree.printPostOder();
                    break;
                }
                case 12: {
                    x = Utils.getInt("Input search value: ");
                    IntBstNode node = tree.search(x);
                    if(node==null) System.out.println("Not found");
                    else System.out.println("Found "+node.key);
                    break;
                }
                case 13: {
                    x = Utils.getInt("Input deleted key");
                    if(tree.deleteByMerging(x))
                        System.out.println("Deleting successfully");
                    else System.out.println("Deleting failed");
                    break;
                }
                case 14: {
                    x = Utils.getInt("Input deleted key: ");
                    if(tree.deleteByCopy(x))
                        System.out.println("Deleting successfully");
                    else System.out.println("Deleting failed");
                    break;
                }
            }
        } while(choice>0 && choice<=mnu.size());
    }
}
