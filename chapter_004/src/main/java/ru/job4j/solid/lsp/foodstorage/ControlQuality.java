package ru.job4j.solid.lsp.foodstorage;

import java.util.List;

public class ControlQuality {
    FoodService foodService;
    List<Storage> storages;

    public ControlQuality(FoodService foodList) {
        this.foodService = foodList;
        storages = Storages.getStorages();
    }

    public void control() {
        var foodList = foodService.getFood();
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

    public void resort() {
        Storages.clearStorages();
        control();
    }
}
