package chap04;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Example1 {

    public static void main(String[] args) {
        String name = "www.skhu.ac.kr";
        try {
            InetAddress address = InetAddress.getByName(name);
            System.out.println(address);
        } catch (UnknownHostException ex) {
            System.out.println("Could not find " + name);
        }
    }

}
