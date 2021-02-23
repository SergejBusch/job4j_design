package ru.job4j.collection;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Article {
    public boolean generateBy(String origin, String line) {
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
