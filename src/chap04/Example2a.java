package chap04;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Example2a {

    public static void main(String[] args) {
        String name = "www.skhu.ac.kr";
        try {
            InetAddress address = InetAddress.getByName(name);
            System.out.println(address);
            System.out.println(address.getHostName());
            System.out.println(address.getCanonicalHostName());
            System.out.println(Arrays.toString(address.getAddress()));
            System.out.println(address.getHostAddress());

            for (byte b : address.getAddress())
                System.out.printf("%d ", b >= 0 ? b : b + 255);
        } catch (UnknownHostException ex) {
            System.out.println("Could not find " + name);
        }
    }

}
