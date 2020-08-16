package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Chat {
    private static final String PAUSE = "pause";
    private static final String START = "start";
    private static final String STOP = "stop";

    private Scanner scanner = new Scanner(System.in);
    private List<String> text = new ArrayList<>();
    private String line;
    private Path file;
    private boolean start = true;

    public Chat(String pathToFile) throws FileNotFoundException {
        file = Paths.get(pathToFile);
        if (!file.toFile().isFile()) {
            throw new FileNotFoundException("Oh no");
        }
        try (var in = new BufferedReader(new FileReader(file.toFile()))) {
            in.lines().forEach(text::add);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void startChat() throws IOException {
        var textList = new ArrayList<String>();
        while (!nextLine().equals(STOP)) {
            textList.add(line);
            if (check(line)) {
                printRandomTextFromFile(textList);
            }
        }
        textList.add(line);
        var writer = new FileWriter("textOutput.txt");
        for (String str : textList) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();    }

    private String nextLine() {
        line = scanner.nextLine();
        return line;
    }

    private boolean check(String line) {
        if (start && line.equals(PAUSE)) {
            start = false;
        } else if (!start && line.equals(START)) {
            start = true;
        }
        return start;
    }

    private void printRandomTextFromFile(List<String> out) {
            var position = new Random().nextInt(text.size() - 1);
            System.out.println(text.get(position));
            out.add(text.get(position));
    }

    public static void main(String[] args) throws IOException {
        new Chat("text.txt").startChat();
    }
}
