package ru.job4j.solid.lsp;

public interface Park {

    boolean park(Car car);

    boolean canPark(Car car);

    int getTruckPlaces();

    int getLightCarPlaces();
}
