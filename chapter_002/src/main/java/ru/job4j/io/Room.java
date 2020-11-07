package ru.job4j.io;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(room));

        final String personJson =
                "{"
                        + "\"hasWindow\":true,"
                        + "\"powerSockets\":4,"
                        + "\"sofa\":"
                        + "{"
                        + "\"material\":\"leather\""
                        + "},"
                        + "\"otherFurniture\":"
                        + "[\"Table\",\"Chair\"]"
                        + "}";

        final Room room2 = gson.fromJson(personJson, Room.class);
        System.out.println(room2);
    }
}
