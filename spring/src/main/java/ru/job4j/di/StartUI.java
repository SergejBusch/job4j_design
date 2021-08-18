package ru.job4j.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class StartUI {

    private Store store;
    private Input input;


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

    @Autowired
    public void setStore(Store store) {
        this.store = store;
    }

    @Autowired
    public void setInput(Input input) {
        this.input = input;
    }
}
