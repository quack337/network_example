package chap04;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Example1b {

    public static void main(String[] args) {
        String name = "www.naver.com";
        try {
            InetAddress[] addresses = InetAddress.getAllByName(name);
            for (InetAddress address : addresses)
                System.out.println(address);
        } catch (UnknownHostException ex) {
            System.out.println("Could not find " + name);
        }
    }

}
