package chap05;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class Example3 {

    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        URI uriObj = new URI("http://nothing.com:8080/context/path/file?id=3");
        System.out.println(uriObj.getScheme());
        System.out.println(uriObj.getHost());
        System.out.println(uriObj.getPort());
        System.out.println(uriObj.getPath());
        System.out.println(uriObj.getQuery());
    }

}
