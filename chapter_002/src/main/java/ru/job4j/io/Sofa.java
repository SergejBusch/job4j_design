package ru.job4j.io;

public class Sofa {
    private String material;

    public Sofa(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Sofa{"
                + "material='" + material + '\''
                + '}';
    }
}
