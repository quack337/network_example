package chap04;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Example4 {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
        while (nis.hasMoreElements()) {
            NetworkInterface ni = nis.nextElement();
            System.out.println(ni);
        }
    }

}
