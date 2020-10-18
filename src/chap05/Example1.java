package chap05;

import java.net.MalformedURLException;
import java.net.URL;

public class Example1 {

    public static void main(String[] args) throws MalformedURLException {
        URL urlObj = new URL("http://nothing.com:8080/context/path/file?id=3");
        System.out.println(urlObj.getProtocol());
        System.out.println(urlObj.getHost());
        System.out.println(urlObj.getPort());
        System.out.println(urlObj.getPath());
        System.out.println(urlObj.getFile());
        System.out.println(urlObj.getQuery());
    }

}
