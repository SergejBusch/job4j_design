package ru.job4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cache {
    private final SoftHashMap<String, String> map = new SoftHashMap<>();

    public String get(String key) throws IOException {
        String value = map.get(key);
        if (value == null) {
            Path path = Paths.get(key);
            value = getString(path);
            map.put(key, value);
        }
        return value;
    }

    private String getString(Path path) throws IOException {
        return Files.readString(path);

    }
}
