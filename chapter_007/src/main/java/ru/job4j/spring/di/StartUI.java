package ru.job4j.spring.di;

import org.springframework.stereotype.Component;

@Component
public class StartUI {

    private Store store;
    private Input input;

    public StartUI(Store store, Input input) {
        this.store = store;
        this.input = input;
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    public String ask(String question) {
        return input.askStr(question);
    }
}
