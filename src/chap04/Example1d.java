package chap04;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Example1d {

    public static void main(String[] args) {
        try {
            byte[] a = new byte[] { (byte)203, (byte)246, 75, 30 };
            InetAddress address = InetAddress.getByAddress(a);
            System.out.println(address);
        } catch (UnknownHostException ex) {
            System.out.println("Could not find this computer's address");
        }
    }

}
