package ru.job4j.solid.lsp.foodstorage;

public class Trash extends Storage {

    boolean check(Food food, int index) {
        return index >= 100;
    }
}
