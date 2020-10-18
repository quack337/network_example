package chap02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Example5a {

    public static String readFile(String filePath, String encoding) throws IOException {
        InputStream in = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(in, encoding);
        StringBuilder builder = new StringBuilder();
        char[] a = new char[1024];
        while (true) {
            int count = reader.read(a);
            if (count == -1) break;
            builder.append(a, 0, count);
        }
        reader.close();
        return builder.toString();
    }

    public static void main(String[] args) throws IOException {
        String s = readFile("c:/temp/c.txt", "UTF-8");
        System.out.println(s);
    }

}
