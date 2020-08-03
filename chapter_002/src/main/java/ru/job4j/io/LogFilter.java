package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            var lines = new ArrayList<String>();
            bufferedReader.lines().filter(e -> e
                    .substring(e.length() - 8, e.length() - 5)
                    .equals("404")).forEach(lines::add);
            return lines;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}