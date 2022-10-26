/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.huffman;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class HuffmanTree {

    TreeNode root;
    FreqCounter freqTable;

    public HuffmanTree(FreqCounter freqTable) {
        this.freqTable = freqTable;
        createTree();
    }

    public HuffmanTree() {
        root = null;
        freqTable = null;
    }

    private TreeNode createIntermediate(int freq) {
        TreeNode newNode = new TreeNode(-1, freq);
        return newNode;
    }

    private void createTree() {
        freqTable.decreaseSort();
        ArrayList<TreeNode> treeList = new ArrayList<>();
        int i = 0;
        while (i < 256) {
            int symbol = freqTable.freqObjs[i].symbol;
            int freq = freqTable.freqObjs[i].freq;
            if (freq > 0) {
                treeList.add(new TreeNode(symbol, freq));
            } else {
                break;
            }
            i++;
        }
        int n = treeList.size();
        while (n > 1) {
            TreeNode node1 = treeList.get(n - 2);
            TreeNode node2 = treeList.get(n - 1);
            int sumFreq = node1.freq + node2.freq;
            TreeNode newNode = createIntermediate(sumFreq);
            newNode.left = node1;
            newNode.right = node2;
            treeList.remove(n - 1);
            treeList.remove(n - 2);
            i = n - 3;
            while (i >= 0 && treeList.get(i).freq <= newNode.freq) {
                i--;
            }
            treeList.add(i + 1, newNode);
            n = treeList.size();
        }
        root = treeList.get(0);
    }

    public void reBuild(int symbol, String codeword) {
        int n = codeword.length();
        char lastBit = codeword.charAt(n - 1);
        TreeNode t = root;
        for (int i = 0; i < codeword.length() - 1; i++) {
            char digit = codeword.charAt(i);
            if (digit == '0') {
                if (t.left == null) {
                    t.left = createIntermediate(0);
                }
                t = t.left;
            } else {
                if (t.right == null) {
                    t.right = createIntermediate(0);
                }
                t = t.right;
            }
        }
        TreeNode newNode = new TreeNode(symbol, 0);
        if (lastBit == '0') {
            t.left = newNode;
        } else {
            t.right = newNode;
        }
    }

    public boolean reBuild(CodewordTable codeTable) {
        root = createIntermediate(0);
        for (int i = 0; i < codeTable.size(); i++) {
            int symbole = codeTable.get(i).symbol;
            String codeword = codeTable.get(i).codeword;
            reBuild(symbole, codeword);
        }
        return true;
    }

}
