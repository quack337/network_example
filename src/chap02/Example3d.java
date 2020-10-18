package chap02;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Example3d {

    static void receive(InputStream in, byte[] a, int bytesToRead) throws IOException {
        DataInputStream din = new DataInputStream(in);
        din.readFully(a, 0, bytesToRead);
    }

    public static void main(String[] args) throws IOException {
        byte[] a = new byte[10];
        receive(System.in, a, 10);
        System.out.println(Arrays.toString(a));
    }

}
