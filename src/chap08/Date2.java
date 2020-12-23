package chap08;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Date2 {

    static String getTime() throws UnknownHostException, IOException {
        try (Socket socket = new Socket("time.nist.gov", 13)) {
            StringBuilder result = new StringBuilder();
            InputStream in = socket.getInputStream();
            while (true) {
                int c = in.read();
                if (c == -1) break;
                result.append((char)c);
            }
            return result.toString();
        }
    }

    static Date parse(String time) throws ParseException {
        DateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
        String[] a = time.split(" ");
        return format.parse(a[1] + " " + a[2] + " UTC");
    }

    public static void main(String[] args) throws Exception {
        String s = getTime();
        Date date = parse(s);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        System.out.println(format.format(date));
    }

}
