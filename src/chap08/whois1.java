package chap08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class whois1 {

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("dict.org", 2628)) {
            socket.setSoTimeout(5000);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            for (String word : new String[] { "gold", "silver", "copper", "man" }) {
                writer.write("DEFINE fd-eng-lat " + word + "\r\n");
                writer.flush();
                while (true) {
                    String line = reader.readLine();
                    if (line.startsWith("25")) break;                                 // 성공 응답의 끝
                    else if (line.startsWith("5")) break;                             // 실패 읍답의 끝
                    else if (line.startsWith("1") || line.startsWith("22")) continue; // 무시
                    else System.out.println(line);                                    // 응답 내용

                }
            }
        }
    }

}
