package chap02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Example3c {

    static int receive(InputStream in, byte[] a, int bytesToRead) throws IOException {
        int bytesRead = 0;
        while (bytesRead < bytesToRead) {
            int result = in.read(a, bytesRead, bytesToRead - bytesRead);
            if (result == -1) break; // end of stream
            bytesRead += result;
        }
        return bytesRead;
    }

    public static void main(String[] args) throws IOException {
        byte[] a = new byte[10];
        int bytesRead = receive(System.in, a, 10);
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, 0, bytesRead)));
    }

}
