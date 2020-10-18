package chap02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example2c {

    public static void fileCopy(String sourceFile, String targetFile) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(sourceFile);
            out = new FileOutputStream(targetFile);
            byte[] a = new byte[1024];
            while (true) {
                int count = in.read(a);
                if (count < 0) break;
                out.write(a, 0, count);
            }
        }
        finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) throws IOException {
        fileCopy("c:/temp/a.txt", "c:/temp/b.txt");
    }
}
