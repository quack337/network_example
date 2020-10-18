package chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example7a {

    public static void main(String[] args) throws Exception {

        String listUrl = "http://www.skhu.ac.kr/board/boardlist.aspx?curpage=1&bsid=10004&searchBun=51";
        String html = getHttpResponse(listUrl);

        String regex = "<a href='boardread.aspx[^']+'>([^<]+)</a>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find())
                System.out.println(matcher.group(1));
    }

    static String getHttpResponse(String url) throws IOException {
        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection)urlObj.openConnection();

        // HTTP request header에 정보를 채운다
        connection.setRequestMethod("GET");                          // GET 방식으로 요청한다.
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");  // 웹브라우저인척 한다

        // HTTP response header 정보에서 문자 인코딩을 파악한다.
        // 문자 인코딩은 UTF-8 아니면 EUC-KR 둘 중의 하나라고 가정한다. (한글 웹페이지라고 가정)
        String contentType = connection.getContentType();
        String encoding = (contentType.toUpperCase().indexOf("UTF-8") >= 0) ? "UTF-8" : "EUC-KR";

        // HTTP Response 본문(body)을 읽어서 문자열로 리턴한다.
        StringBuffer builder = new StringBuffer();
        try (BufferedReader input =
                new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding))) {
            String s;
            while ((s = input.readLine()) != null) {
                builder.append(s);
                builder.append('\n');
            }
        }
        return builder.toString();
    }

}
