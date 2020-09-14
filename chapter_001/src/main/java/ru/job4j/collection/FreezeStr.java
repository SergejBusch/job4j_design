package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        AtomicInteger index = new AtomicInteger();

        var letters = new HashMap<Integer, Integer>(left.chars()
                .collect(HashMap::new, (m, i)
                        -> m.put(index.getAndIncrement(), i), Map::putAll));

        for (char c : right.toCharArray()) {
            if (!letters.containsValue((int) c)) {
                return false;
            } else {
                letters.remove(left.indexOf(c));
            }
        }
        return true;
    }
}