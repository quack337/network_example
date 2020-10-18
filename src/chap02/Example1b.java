package chap02;

import java.io.IOException;
import java.io.OutputStream;

public class Example1b {

    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int lastPrintableCharacter = 126;
        int size = (lastPrintableCharacter - firstPrintableCharacter + 1) + 2;
        byte[] a = new byte[size];
        int index = 0;
        for (int ch = firstPrintableCharacter; ch <= lastPrintableCharacter; ++ch)
            a[index++] = (byte)ch;
        a[index++] = '\r'; // CR, carrage return
        a[index++] = '\n'; // LF, line feed
        out.write(a);
    }

    public static void main(String[] args) throws IOException {
        generateCharacters(System.out);
    }
}
