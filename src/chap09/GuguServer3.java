package chap09;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuguServer3 {

    static final Logger auditLogger = Logger.getLogger("audit");
    static final Logger errorLogger = Logger.getLogger("error");

    public static void main(String[] args) {
        final int PORT = 9090;
        try (ServerSocket server = new ServerSocket(PORT)) {
            ExecutorService executor = Executors.newFixedThreadPool(500);
            while (true) {
                try {
                    Socket connection = server.accept();
                    executor.submit(new GuguTask(connection));
                } catch (IOException ex) {
                    errorLogger.log(Level.SEVERE, "accept error", ex);
                } catch (RuntimeException ex) {
                    errorLogger.log(Level.SEVERE, "unexpected error", ex);
                }
            }
        } catch (Exception ex) {
            errorLogger.log(Level.SEVERE, "couldn't start", ex);
        }
    }

    static class GuguTask implements Runnable {
        Socket socket;

        public GuguTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Socket autoClose = socket) {
                auditLogger.log(Level.INFO, "connected " + socket.getRemoteSocketAddress());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                while (true) {
                    int a = in.readInt();
                    int b = in.readInt();
                    out.writeInt(a * b);
                    out.flush();
                }
            } catch (IOException ex) {
            }
        }
    }
}
