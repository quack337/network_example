package chap02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Example4 {

    public static void main(String[] args) throws IOException {
        OutputStream out = new FileOutputStream("c:/temp/c.txt");
        OutputStreamWriter writer = new OutputStreamWriter(out, "UTF8");
        writer.write("안녕하세요");
        System.out.println(writer.getEncoding());
        writer.close();
    }

}
