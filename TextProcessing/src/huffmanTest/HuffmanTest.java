/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanTest;

import java.io.File;
import text.huffman.HuffmanDecoder;
import text.huffman.HuffmanEncoder;
import text.huffman.HuffmanZipResult;

/**
 *
 * @author PC
 */
public class HuffmanTest {
    public static void main(String[] args) {
        String src = "Don't le me alone to night";
        System.out.println("Test encoder on String: ");
        System.out.println("______________________");
        HuffmanEncoder encoder = new HuffmanEncoder(src);
        System.out.println("Source str: " + src);
        System.out.println("Codeword table: " + encoder.getCodeTable());
        System.out.println("Encoded str: " + encoder.getEncodeStr());
        HuffmanZipResult zResult = encoder.createZipResult("No name");
        System.out.println("\nInformantion about zipped result: \n" + zResult);
        System.out.println("Zipping rate: " + encoder.getCompressRate() * 100 + "%");
        System.out.println("\nTest Decoder on String: ");
        System.out.println("_________________________");
        HuffmanDecoder decoder = new HuffmanDecoder(zResult);
        decoder.decode();
        String decodedStr = decoder.getSrcString();
        System.out.println("Decoded string: " + decodedStr);
        String srcFilename = "test1.doc";
        String zipFilename = "test1_ZIPPED.huf";
        String decodedFilename = "test1_HUF_unzip.doc";
        File f;
        f = new File(srcFilename);
        System.out.println("Test encoder on file: ");
        System.out.println("________________________");
        System.out.println("Please wait to compress file.");
        encoder = new HuffmanEncoder(f);
        encoder.writeZipFile(srcFilename, zipFilename);
        System.out.println("Write zip file:done.\n");
        System.out.println("Zipping rate: " + encoder.getCompressRate() * 100 + "%");
        System.out.println("\n Test Decoder on file: ");
        System.out.println("__________________________");
        f = new File(zipFilename);
        decoder = new HuffmanDecoder(f);
        System.out.println("Please wait to decompress file.");
        decoder.decode();
        decoder.wirteDecodedResult(decodedFilename);
        System.out.println("Decode: done.\n");
    }
}
