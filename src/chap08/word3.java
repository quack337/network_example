package chap08;

import java.net.InetSocketAddress;
import java.net.Socket;

public class word3 {

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("dict.org", 2628)) {
            InetSocketAddress remoteAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
            InetSocketAddress localAddress = (InetSocketAddress)socket.getLocalSocketAddress();

            System.out.printf("%s %s %d\n", remoteAddress.getAddress(), remoteAddress.getHostName(), remoteAddress.getPort());
            System.out.printf("%s %s %d\n", localAddress.getAddress(), localAddress.getHostName(), localAddress.getPort());
        }
    }

}
