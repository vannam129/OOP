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
public class CodewordGenerator {
    CodewordTable codeTable;
    HuffmanTree tree;

    public CodewordGenerator(HuffmanTree tree) {
        this.tree = tree;
        codeTable = new CodewordTable();
    }
    private void generateCodewords(TreeNode p, String codeInited){
        if(p!=null){
            int L = codeInited.length();
            if(p.left==null && p.right==null){
                int symbol = p.symbol;
                codeTable.get(symbol).codeword = codeInited;
            }
            generateCodewords(p.left, codeInited + "0");
            generateCodewords(p.right, codeInited + "1");
        }
    }
    public void generateCodewords(){
        generateCodewords(tree.root, "");
    }

    public CodewordTable getCodeTable() {
        return codeTable;
    }

    public void setCodeTable(CodewordTable codeTable) {
        this.codeTable = codeTable;
    }
    
    
}
