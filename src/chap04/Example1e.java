package chap04;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Example1e {

    public static void main(String[] args) {
        try {
            String name = "www.skhu.ac.kr";
            byte[] a = new byte[] { (byte)203, (byte)246, 75, 30 };
            InetAddress address = InetAddress.getByAddress(name, a);
            System.out.println(address);
        } catch (UnknownHostException ex) {
            System.out.println("Could not find this computer's address");
        }
    }

}
