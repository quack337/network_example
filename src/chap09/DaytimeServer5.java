package chap09;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DaytimeServer5 {

    public static void main(String[] args) {
        final int PORT = 13;
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket socket = server.accept();
                    Thread thread = new Thread(new DaytimeTask(socket));
                    thread.start();
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
                 ObjectOutputStream out = new ObjectOutputStream(out0);
                Message msg = new Message("안녕하세요", new Date());
                out.writeObject(msg);
                out.flush();
            } catch (Exception ex) {
            }
        }
    }
}
