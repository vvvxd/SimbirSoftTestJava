package utiles;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Parser {
    public static String parseHTML(String pageUrl) throws IOException {
        URLConnection url = new URL(pageUrl).openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String inputLine;
        while ((inputLine = reader.readLine()) != null) {
            builder.append(inputLine);
        }
        reader.close();
        Document doc = Jsoup.parse(builder.toString());
        return doc.body().text();
    }
}
