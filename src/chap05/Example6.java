package chap05;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Example6 {

    public static void main(String[] args) throws UnsupportedEncodingException  {

        // 인코딩 오류
        String s = "http://www.google.com/search?q=흥부 놀부";
        String urla = URLEncoder.encode(s, "UTF-8");
        System.out.println(urla);

        // 인코딩 OK
        String urlb = "http://www.google.com/search?q=" + URLEncoder.encode("흥부 놀부", "UTF-8");
        System.out.println(urlb);

        // 디코딩 Ok
        String t = URLDecoder.decode(urlb, "UTF-8");
        System.out.println(t);
    }

}
