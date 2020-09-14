package ru.job4j.collection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Article {
    public static boolean generateBy(String origin, String line) {
        var text = new HashMap<String, String>(Arrays.stream(origin.split(" "))
          .collect(HashMap::new, (m, s)
                  -> m.put(s.replaceAll("[^\\p{L}]", ""), null), Map::putAll));
        for (String word : line.split(" ")) {
            if (!text.containsKey(word)) {
                return false;
            }
        }
        return true;
    }
}
