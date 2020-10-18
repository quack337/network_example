package chap05;

import java.net.URI;
import java.net.URISyntaxException;

public class Example4 {

    public static void main(String[] args) throws URISyntaxException {
        URI uriA = new URI("http://www.ibiblio.com");
        URI uriB = new URI("http://ibiblio.com");
        System.out.println(uriA.equals(uriB));

        URI uriC = new URI("https://www.ibiblio.com");
        System.out.println(uriA.equals(uriC));

        URI uriD = new URI("HTTP://WWW.IBIBLIO.COM");
        System.out.println(uriA.equals(uriD));
    }

}
