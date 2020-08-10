package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DuplicateExample {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        var duplicateSearch = new DuplicateSearch();
        Files.walkFileTree(path, duplicateSearch);
        for (Path p : duplicateSearch.getDuplicates()) {
            System.out.println(p);
        }

    }
}
