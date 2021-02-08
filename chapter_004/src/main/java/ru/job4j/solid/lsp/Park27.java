package ru.job4j.solid.lsp;

public class Park27 implements Park {
    int truckPlaces;
    int lightCarPlaces;

    public Park27(int truckPlaces, int carPlaces) {
        this.truckPlaces = truckPlaces;
        this.lightCarPlaces = carPlaces;
    }

    @Override
    public boolean park(Car car) {
        if (canPark(car)) {
            if (car.size() > 1 && truckPlaces > 0) {
                truckPlaces -= 1;
            } else {
                lightCarPlaces -= car.size();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean canPark(Car car) {
        int size = car.size();
        if (size > 1) {
            if (truckPlaces > 0) {
                return true;
            } else {
                return lightCarPlaces >= size;
            }
        } else {
            return size == 1 && lightCarPlaces > 0;
        }
    }

    @Override
    public int getTruckPlaces() {
        return truckPlaces;
    }

    @Override
    public int getLightCarPlaces() {
        return lightCarPlaces;
    }
}
