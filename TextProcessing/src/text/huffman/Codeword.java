/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.huffman;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Codeword implements Serializable{
    int symbol;
    String codeword;

    public Codeword(int symbol, String codeword) {
        this.symbol = symbol;
        this.codeword = codeword;
    }

    public Codeword(int symbol) {
        this.symbol = symbol;
        this.codeword = "";
    }

    @Override
    public String toString() {
        return "{" + "symbol=" + symbol + ", codeword=" + codeword + '}';
    }
    
}
