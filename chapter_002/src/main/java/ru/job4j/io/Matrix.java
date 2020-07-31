package ru.job4j.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Matrix {
    public static void multiple(int size) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {

            for (int i = 0; i <= size; i++) {
                for (int j = 0; j <= size; j++) {
                    out.write((i + " * " + j + " = " + i * j + " ").getBytes());
                }
            out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        multiple(5);
    }
} 
