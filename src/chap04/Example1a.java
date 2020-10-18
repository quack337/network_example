package chap04;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Example1a {

    public static void main(String[] args) {
        String name = "203.246.75.30";
        try {
            InetAddress address = InetAddress.getByName(name);
            System.out.println(address);
            System.out.println(address.getCanonicalHostName());
        } catch (UnknownHostException ex) {
            System.out.println("Could not find " + name);
        }
    }

}
