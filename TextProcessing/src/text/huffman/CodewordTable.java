/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.huffman;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class CodewordTable extends ArrayList<Codeword>
        implements Serializable {

    public CodewordTable() {
        super(256);
        for (int i = 0; i < 256; i++) {
            this.add(new Codeword(i));
        }
    }

    public CodewordTable reduce() {
        for (int i = this.size() - 1; i >= 0; i--) {
            if (this.get(i).codeword == null
                    || this.get(i).codeword.length() == 0) {
                this.remove(i);
            }
        }
        return this;
    }

    @Override
    public String toString() {
        String result = "[";
        for (Codeword x : this) {
            if (x != null && x.codeword.length() > 0) {
                result += x + "'";
            }
        }
        return result + "]";
    }

}
