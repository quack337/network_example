package chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example11 {

    public static void main(String[] args) throws Exception {

        String articleUrl =
           "http://www.skhu.ac.kr/board/boardread.aspx?idx=35974&curpage=1&bsid=10004&searchBun=51";
        String html = getHttpResponse(articleUrl);

        String regex = "<td colspan=\"4\" class=\"board_view_con\">(.+)\n" +
                       "            </td>\n" +
                       "        </tr>\n" +
                       "    </tbody>\n" +
                       "</table>\n" +
                       "<table summary=\"이전글";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html);
        if (matcher.find())
                System.out.println(matcher.group(1));

    }

    static String getHttpResponse(String url) throws IOException {
        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection)urlObj.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        String contentType = connection.getContentType();
        String encoding = (contentType.toUpperCase().indexOf("UTF-8") >= 0) ? "UTF-8" : "EUC-KR";
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
