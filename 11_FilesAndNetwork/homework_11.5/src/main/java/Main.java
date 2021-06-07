import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        JSONObject map = new JSONObject();
        JSONObject readMap = new JSONObject();

        map = createJObj();
        writer(map);
        readMap = reader();
        JSONObject obj = (JSONObject) readMap.get("stations");
        obj.forEach((o, o2) -> System.out.printf("Линия: %s содержит: %d станций%n", o.toString(), o2.toString().split(",").length));

    }

    public static JSONObject reader() {
        JSONParser parser = new JSONParser();
        JSONObject map = null;
        try {
            map = (JSONObject) parser.parse(new BufferedReader(new FileReader(new File("data/map.json"))));
        } catch (ParseException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void writer(JSONObject map) {
        //Запись json в файл для дальнейшей обработки
        try (FileWriter writer = new FileWriter("data/map.json")) {
            writer.write(map.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static JSONObject createJObj() {
        JSONObject map = new JSONObject();
        JSONArray arrayLines = new JSONArray();
        JSONObject obj = new JSONObject();
        JSONArray arrayStations = new JSONArray();
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element el = doc.getElementById("metrodata");
        // получение номеров линий и их названий
        el.getElementsByClass("js-metro-line").forEach(element -> {
            JSONObject objL = new JSONObject();
            objL.put("number", element.attr("data-line"));
            objL.put("line", element.text());
            arrayLines.add(objL);
        });
        map.put("lines", arrayLines);

        // Получение станций в линииях
        el.getElementsByClass("js-metro-stations").forEach(element -> {
            element.getElementsByClass("name").forEach(element1 -> arrayStations.add(element1.text()));
            obj.put(element.attr("data-line"), arrayStations.clone());
            map.put("stations", obj);
            arrayStations.clear();
        });
        return map;
    }
}