package chap05;

import java.net.MalformedURLException;
import java.net.URL;

public class Example2 {

    public static void main(String[] args) throws MalformedURLException {
        URL urlA = new URL("http://www.ibiblio.com");
        URL urlB = new URL("http://ibiblio.com");
        System.out.println(urlA.equals(urlB));

        URL urlC = new URL("https://www.ibiblio.com");
        System.out.println(urlA.equals(urlC));
    }

}
