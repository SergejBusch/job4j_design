package ru.job4j.solid.isp;

import java.util.Scanner;

public class ScannerInput implements Input {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String getString() {
        return scanner.nextLine();
    }
}
