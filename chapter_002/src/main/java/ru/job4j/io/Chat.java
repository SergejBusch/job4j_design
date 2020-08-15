package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Chat {
    private Scanner scanner = new Scanner(System.in);
    private String line;
    private Path file;
    private boolean start = true;

    public Chat(String pathToFile) throws FileNotFoundException {
        file = Paths.get(pathToFile);
        if (!file.toFile().isFile()) {
            throw new FileNotFoundException("Oh no");
        }
    }

    public void startChat() {
        try (var out = new PrintWriter(new FileOutputStream("chatOutput.txt"))) {
            while (!nextLine().equals("stop")) {
                out.write(line + System.lineSeparator());
                if (check(line)) {
                    printRandomTextFromFile(out);
                }
            }
            out.write(line + System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String nextLine() {
        line = scanner.nextLine();
        return line;
    }

    private boolean check(String line) {
        if (start && line.equals("pause")) {
            start = false;
        } else if (!start && line.equals("start")) {
            start = true;
        }
        return start;
    }

    private void printRandomTextFromFile(PrintWriter out) {
        try (var in = new BufferedReader(new FileReader(file.toFile()))) {
            var sb = new StringBuilder();
            in.lines().forEach(sb::append);
            String[] stringArray = sb.toString().split(" ");
            var position = new Random().nextInt(stringArray.length - 5);
            for (int i = position; i < new Random().nextInt(3) + 3 + position; i++) {
                System.out.print(stringArray[i] + " ");
                out.write(stringArray[i] + " ");
            }
            System.out.println();
            out.write(System.lineSeparator());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Chat("text.txt").startChat();
    }
}
