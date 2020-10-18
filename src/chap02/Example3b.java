package chap02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Example3b {

    static void receive(InputStream in, byte[] a, int bytesToRead) throws IOException {
        int bytesRead = 0;
        while (bytesRead < bytesToRead) {
            System.out.printf("%d\n",  bytesRead);
            bytesRead += in.read(a, bytesRead, bytesToRead - bytesRead);
        }
    }

    public static void main(String[] args) throws IOException {
        byte[] a = new byte[10];
        receive(System.in, a, 10);
        System.out.println(Arrays.toString(a));
    }

}
