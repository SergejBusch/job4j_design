package ru.job4j.solid.lsp.foodstorage;

public class Warehouse extends Storage {

    boolean check(Food food, int index) {
        return index < 25;
    }
}
