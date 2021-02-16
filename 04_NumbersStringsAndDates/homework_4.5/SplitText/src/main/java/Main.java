import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        String text = "Everyone could notice that people often complain and say t.";
        splitTextIntoWords(text);
    }

    public static String splitTextIntoWords(String text) {
        //TODO реализуйте метод
        StringBuilder builder = new StringBuilder();
        String[] resultText = text.split("[^\\’||\\w]+[0-9]*\\W?");
        if (resultText[0].equals(""))
            return "";
        for (int i = 0; i < resultText.length; i++) {
            // долго думал почему не проходит текст, оказалось, что в конец добавляется пустая строка
            if (i == resultText.length - 1) {
                builder.append(resultText[i]);
                continue;
            }
            builder.append(resultText[i] + "\r\n");
        }
        return builder.toString();
    }

}