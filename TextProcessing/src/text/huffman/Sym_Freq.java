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
public class Sym_Freq implements Comparable<Sym_Freq> {

    int symbol;
    int freq;

    public Sym_Freq(int symbol, int freq) {
        this.symbol = symbol;
        this.freq = freq;
    }

    @Override
    public int compareTo(Sym_Freq t) {
        int d = this.freq - t.freq;
        return d > 0 ? -1 : d < 0 ? 1 : 0;
    }

    @Override
    public String toString() {
        return "(" + "symbol=" + symbol + ", freq=" + freq + ')';
    }

}
