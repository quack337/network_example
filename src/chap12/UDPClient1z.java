package chap12;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPClient1z {
    static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    static final String HOST = "localhost";
    static final int PORT = 7070;

    public static void main(String[] args) throws UnknownHostException  {
        InetAddress hostAddress = InetAddress.getByName(HOST);
        for (int i = 0; i < 100; ++i)
            new Thread(new SendTask(hostAddress, PORT)).start();
    }

    static class SendTask implements Runnable {
        InetAddress hostAddress;
        int port;

        public SendTask(InetAddress hostAddress, int port) {
            this.hostAddress = hostAddress;
            this.port = port;
        }

        @Override
        public void run() {
            try (DatagramSocket socket = new DatagramSocket(0)) {

                for (int i = 0; i < 10; ++i) {
                    System.out.printf("sending %d\n", i);
                    String s = format.format(new Date());
                    byte[] data = s.getBytes("US-ASCII");
                    DatagramPacket packet = new DatagramPacket(data, data.length, hostAddress, PORT);
                    socket.send(packet);
                    Thread.sleep(10);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
