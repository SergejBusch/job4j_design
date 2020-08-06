package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Analise {

    private static boolean start;

    public void unavailable(String source, String target) {
        try (var in = new BufferedReader(new FileReader(source));
             var out = new PrintWriter(new FileOutputStream(target))) {
            in.lines().forEach(n -> {
                if (!start && n.startsWith("400") || n.startsWith("500")) {
                    start = true;
                    out.write(n.substring(4) + ";");
                } else if (start && n.startsWith("200") || n.startsWith("300")) {
                    start = false;
                    out.println(n.substring(4) + ";");
                }
            });
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