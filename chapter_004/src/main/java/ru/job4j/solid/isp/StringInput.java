package ru.job4j.solid.isp;

public class StringInput implements Input {
    String[] input;
    int i = 0;

    public StringInput(String... input) {
        this.input = input;
    }

    @Override
    public String getString() {
        return input[i++];
    }
}
