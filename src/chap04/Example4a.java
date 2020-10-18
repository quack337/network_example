package chap04;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;

public class Example4a {

    public static void main(String[] args) throws SocketException {
        NetworkInterface ni = NetworkInterface.getByName("eth2");

        System.out.println(Arrays.toString(ni.getHardwareAddress()));

        for (byte b : ni.getHardwareAddress())
            System.out.printf("%02x ", b);
        System.out.println();

        Enumeration<InetAddress> addresses = ni.getInetAddresses();
        while (addresses.hasMoreElements())
            System.out.println(addresses.nextElement());
    }

}
