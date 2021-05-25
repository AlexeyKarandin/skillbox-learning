import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        String url = "https://lenta.ru/";
        Document document;
        try {
            document = Jsoup.connect(url).get();
            System.out.println(document.title());
            Elements images = document.getElementsByClass("g-picture");
            for (Element image : images) {
                ImageIO.write(ImageIO.read(new URL(image.attr("abs:src"))), "jpg",
                        new File("images/" + image.attr("src").substring(image.attr("src").lastIndexOf("/") + 1)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.walk(Path.of("images/")).skip(1).forEach(file -> System.out.println(file.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
