package ru.job4j.solid.lsp;

public class LightCar implements Car {
    private int size = 1;

    @Override
    public int size() {
        return size;
    }
}
