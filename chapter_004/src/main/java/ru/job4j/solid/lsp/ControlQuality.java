package ru.job4j.solid.lsp;

import java.util.List;

public class ControlQuality {
    List<Food> foodList;
    List<Storage> storages;

    public ControlQuality(List<Food> foodList) {
        this.foodList = foodList;
        storages = Storages.getStorages();
    }

    public void control() {
        List<Storage> storages = Storages.getStorages();
        for (var food : foodList) {
            int index = CheckExp.check(food);
            addToStorage(food, index);
        }
    }

    private void addToStorage(Food food, int index) {
        for (var storage : this.storages) {
            if (storage.add(food, index)) {
                break;
            }
        }
    }

    public List<Storage> getStorages() {
        return storages;
    }
}
