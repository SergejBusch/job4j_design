package ru.job4j.io;

import org.json.JSONObject;

import java.util.Arrays;

public class Room {

    private final boolean hasWindows;
    private final int powerSockets;
    private final Sofa sofa;
    private final String[] otherFurniture;

    public Room(boolean hasWindows, int powerSockets, Sofa sofa, String... otherFurniture) {
        this.hasWindows = hasWindows;
        this.powerSockets = powerSockets;
        this.sofa = sofa;
        this.otherFurniture = otherFurniture;
    }

    public boolean isHasWindows() {
        return hasWindows;
    }

    public int getPowerSockets() {
        return powerSockets;
    }

    public Sofa getSofa() {
        return sofa;
    }

    public String[] getOtherFurniture() {
        return otherFurniture;
    }

    @Override
    public String toString() {
        return "Room {"
                + "hasWindows=" + hasWindows
                + ", powerSockets=" + powerSockets
                + ", sofa=" + sofa
                + ", otherFurniture=" + Arrays.toString(otherFurniture)
                + '}';
    }

    public static void main(String[] args) {
        var room = new Room(true, 4, new Sofa("leather"), "Table", "Chair");

        final String personJson =
                "{"
                        + "\"hasWindows\":true,"
                        + "\"powerSockets\":4,"
                        + "\"sofa\":"
                        + "{"
                        + "\"material\":\"leather\""
                        + "},"
                        + "\"otherFurniture\":"
                        + "[\"Table\",\"Chair\"]"
                        + "}";
        JSONObject jo = new JSONObject(personJson);

        System.out.println(jo);
        System.out.println(new JSONObject(room));

    }
}
