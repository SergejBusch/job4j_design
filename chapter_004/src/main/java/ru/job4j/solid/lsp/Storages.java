package ru.job4j.solid.lsp;

import java.util.List;

public class Storages {
    private static List<Storage> storages = List.of(new Warehouse(), new Shop(), new Trash());

    public static List<Storage> getStorages() {
        return storages;
    }
}
