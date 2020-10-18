package chap05;

import java.net.URI;
import java.net.URISyntaxException;

public class Example5 {

    public static void main(String[] args) throws URISyntaxException {
        URI 현재주소 = new URI("http://localhost:8088/student/list");
        String 상대주소 = "edit?id=3";

        URI 절대주소 = 현재주소.resolve(상대주소);
        System.out.println(절대주소);
    }

}
