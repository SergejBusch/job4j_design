package ru.job4j.spring.di;

public class ConsoleInput implements Input {

    @Override
    public String askStr(String question) {
        return question + "!";
    }
}
