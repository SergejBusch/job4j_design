package ru.job4j.spring.di;

import org.springframework.stereotype.Component;

@Component
public class ConsoleInput implements Input {

    @Override
    public String askStr(String question) {
        return question + "!";
    }
}
