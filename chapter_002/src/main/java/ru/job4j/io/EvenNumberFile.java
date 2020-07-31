package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int charText;
            var number = new StringBuilder();
            while ((charText = in.read()) != -1) {
                if (!Character.toString(charText).equals(System.lineSeparator())) {
                    number.append((char) charText);
                } else {
                    print(number);
                }
            }
            print(number);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void print(StringBuilder number) {
        System.out.println(number
                + (Integer.parseInt(number.toString()) % 2 == 0
                ? " is even" : " is odd") + " number");
        number.setLength(0);
    }
}