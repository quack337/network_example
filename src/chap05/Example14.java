package chap05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example14 {

    static final String 저장폴더 = "c:/temp";

    public static void main(String[] args) throws Exception {
        String listUrl = "http://www.skhu.ac.kr/board/boardlist.aspx?curpage=1&bsid=10004&searchBun=51";
        List<Article> list = getArticleList(listUrl);
        for (Article article : list) {
            String idx = article.getIdx();
            String body = getArticleBody(idx);
            article.setBody(body);
            String path = 저장폴더 + "/##.html".replace("##", idx);
            writeTextFile(path, body);
        }
    }

    static void writeTextFile(String path, String text) throws IOException {
        try (BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "EUC-KR"))) {
            writer.write(text);
            writer.close();
            System.out.println(path + " 저장완료");
        }
    }

    static List<Article> getArticleList(String url) throws IOException {
        List<Article> list = new ArrayList<Article>();
        String html = getHttpResponse(url);
        String regex = "<a href='boardread.aspx\\?idx=([0-9]+)[^>]+>([^<]+)</a>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
                Article article = new Article();
                article.setIdx(matcher.group(1));
                article.setTitle(matcher.group(2));
                list.add(article);
        }
        return list;
    }

    static String getArticleBody(String idx) throws IOException {
        String articleUrl =
                "http://www.skhu.ac.kr/board/boardread.aspx?idx=9999&curpage=1&bsid=10004&searchBun=51";
        articleUrl = articleUrl.replace("9999", idx);
        String html = getHttpResponse(articleUrl);

        String regex = "<td colspan=\"4\" class=\"board_view_con\">(?<body>.+)\n" +
                       "            </td>\n" +
                       "        </tr>\n" +
                       "    </tbody>\n" +
                       "</table>\n" +
                       "<table summary=\"이전글";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html);
        return matcher.find() ? matcher.group("body") : null;
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

