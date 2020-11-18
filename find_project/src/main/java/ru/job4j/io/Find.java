package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Find {
    static List<String> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        validate(args);
        Path start = Paths.get(args[1]);
        Predicate<Path> predicate = null;
        if (args[4].equals("-m")) {
            predicate = (e -> e.getFileName().toString().endsWith(args[3].replace("*", "")));
        } else if (args[4].equals("-f")) {
            predicate = (e -> e.toString().equals(args[3]));
        }
        searchFile(start, predicate);
        printToFile(args);

    }

    private static void searchFile(Path start, Predicate<Path> predicate) throws IOException {
        var visitor = new Visitor(predicate);
        Files.walkFileTree(start, visitor);
        lines = visitor.getLines();
    }

    private static void printToFile(String[] args) throws IOException {
        System.out.println("founded files : " + lines.size());
        if (lines.size() > 0) {
            Files.write(Paths.get(args[6]), lines, StandardCharsets.UTF_8);
        } else {
            System.out.println("nothing found");
        }
    }

    private static void validate(String[] args) {
        boolean error = false;
        if (args.length != 7) {
            System.out.println("wrong number of arguments");
            error = true;
        } else if (!args[0].equals("-d")) {
            System.out.println("first parameter should be -d");
            error = true;
        } else if (Files.notExists(Path.of(args[1]))) {
            System.out.println("directory not exist");
            error = true;
        } else if (!args[2].equals("-n")) {
            System.out.println("third parameter should be -n");
            error = true;
        } else if (!args[4].equals("-m") && !args[4].equals("-f")) {
            System.out.println("fifth parameter should be -m or -f");
            error = true;
        } else if (!args[5].equals("-o")) {
            System.out.println("sixth parameter should be -o");
            error = true;
        }
        if (error) {
            System.out.println(
                    "so for example must be - java -jar find.jar -d c:/ -n *.txt -m -o log.txt");
            System.exit(0);
        }

    }
}
