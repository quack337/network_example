package chap02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example2e {

    public static void fileCopy(String sourceFile, String targetFile) throws IOException {
        try (FileInputStream in = new FileInputStream(sourceFile);
             FileOutputStream out = new FileOutputStream(targetFile)) {
            while (true) {
                int b = in.read();
                if (b == -1) break;
                out.write(b);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        fileCopy("c:/temp/a.txt", "c:/temp/b.txt");
    }
}
