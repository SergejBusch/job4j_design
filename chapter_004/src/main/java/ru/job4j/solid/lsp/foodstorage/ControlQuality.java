package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    FoodService foodService;
    List<Storage> storages;

    public ControlQuality(FoodService foodList) {
        this.foodService = foodList;
        storages = new Storages().getStorages();
    }

    public void control() {
        var foodList = foodService.getFood();
        sort(foodList);
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public void resort() {
        List<Food> foodList = new ArrayList<>();
        for (var st : storages) {
            var list = st.checkAffiliation();
            if (!list.isEmpty()) {
                foodList.addAll(list);
            }
        }
        if (!foodList.isEmpty()) {
            sort(foodList);
        }

    }

    private void addToStorage(Food food, int index) {
        for (var storage : this.storages) {
            if (storage.add(food, index)) {
                break;
            }
        }
    }

    private void sort(List<Food> foodList) {
        for (var food : foodList) {
            int index = CheckExp.check(food);
            addToStorage(food, index);
        }
    }
}
