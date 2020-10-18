package chap02;

import java.io.IOException;
import java.io.OutputStream;

public class Example1e {

    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int lastPrintableCharacter = 126;
        for (int ch = firstPrintableCharacter; ch <= lastPrintableCharacter; ++ch)
            out.write(ch);
        out.write('\r');
        out.close();
    }

    public static void main(String[] args) throws IOException {
        generateCharacters(System.out);
    }
}
