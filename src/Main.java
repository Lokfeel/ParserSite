import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String pathDownload = "G:\\download\\";
        try {
            Document doc = Jsoup.connect("https://www.onliner.by/").get();
            Elements elements = doc.select("img");
            int numName = 0;
            for(Element elem : elements){
                try {
                    String temp = elem.attr("data-src");
                    URL url = new URL(temp);
                    InputStream in = new BufferedInputStream(url.openStream(), 200);
                    OutputStream out = new BufferedOutputStream(new FileOutputStream(pathDownload + numName++ + ".jpg"));
                    for(int i; (i = in.read()) != -1;){
                        out.write(i);
                    }
                    in.close();
                    out.close();
                }
                catch (MalformedURLException ex){
                    ex.getMessage();
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
