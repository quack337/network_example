package chap04;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Example3 {

    public static void main(String[] args) {
        String name = "www.skhu.ac.kr";
        try {
            InetAddress address = InetAddress.getByName(name);
            System.out.println(address);
            System.out.println(address.isReachable(2000));
        } catch (UnknownHostException ex) {
            System.out.println("Could not find " + name);
        } catch (IOException e) {
            System.out.println("Is not reachable");
        }
    }

}
