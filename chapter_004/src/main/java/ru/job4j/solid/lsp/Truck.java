package ru.job4j.solid.lsp;

public class Truck implements Car {
    private int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
}
