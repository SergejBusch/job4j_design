package ru.job4j.solid.lsp;

public class Park27 implements Park {
    
    public Park27(int truckPlaces, int carPlaces) {
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public boolean canPark(Car car) {
        return false;
    }

    @Override
    public int getTruckPlaces() {
        return 0;
    }

    @Override
    public int getLightCarPlaces() {
        return 0;
    }
}
