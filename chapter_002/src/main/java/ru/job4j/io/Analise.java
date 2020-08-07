package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;

public class Analise {
    private static boolean start;

    public void unavailable(String source, String target) {
        try (var in = new BufferedReader(new FileReader(source));
             var writer = new FileWriter(target)
        ) {
            var data = new ArrayList<String>();
            in.lines().forEach(n -> {
                if (!start && n.startsWith("400") || n.startsWith("500")) {
                    start = true;
                    data.add(n.substring(4) + ";");
                } else if (start && n.startsWith("200") || n.startsWith("300")) {
                    start = false;
                    int index = data.size() - 1;
                    data.set(index, data.get(index) + n.substring(4) + ";");
                }
            });

            for (String str : data) {
                writer.write(str + System.lineSeparator());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}