package chap08;

import java.net.Socket;

public class word2 {

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("dict.org", 2628)) {

            System.out.printf("remote address = %s\n", socket.getInetAddress());
            System.out.printf("remote port = %d\n", socket.getPort());
            System.out.printf("local address = %s\n", socket.getLocalAddress());
            System.out.printf("local port = %d\n", socket.getLocalPort());
        }
    }

}
