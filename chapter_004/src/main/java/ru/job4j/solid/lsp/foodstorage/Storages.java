package ru.job4j.solid.lsp.foodstorage;

import java.util.List;

public class Storages {
    private  List<Storage> storages = List.of(new Warehouse(), new Shop(), new Trash());

    public  List<Storage> getStorages() {
        return storages;
    }

    public  void clearStorages() {
        storages = List.of(new Warehouse(), new Shop(), new Trash());
    }
}
