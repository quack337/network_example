package chap09;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaytimeServer6 {

    public static void main(String[] args) {
        final int PORT = 13;
        try (ServerSocket server = new ServerSocket(PORT)) {
            ExecutorService executor = Executors.newFixedThreadPool(500);
            while (true) {
                try {
                    Socket socket = server.accept();
                    executor.submit(new DaytimeTask(socket));
                } catch (IOException ex) {
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    static class DaytimeTask implements Runnable {
        Socket socket;

        public DaytimeTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (OutputStream out0 = socket.getOutputStream()) {
                ObjectOutputStream out1 = new ObjectOutputStream(out0);
                Message msg = new Message("안녕하세요", new Date());
                out1.writeObject(msg);
                out1.close();
                Thread.sleep(100);
            } catch (Exception ex) {
            }
        }
    }
}
