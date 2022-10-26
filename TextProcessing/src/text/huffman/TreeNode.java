/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.huffman;

/**
 *
 * @author PC
 */
public class TreeNode implements Comparable<TreeNode> {

    int symbol;
    int freq;
    TreeNode left, right;

    public TreeNode(int symbol, int freq) {
        this.symbol = symbol;
        this.freq = freq;
        left = right = null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(TreeNode t) {
        int d = freq - t.freq;
        return d > 0 ? -1 : d < 0 ? 1 : 0;
    }

}
