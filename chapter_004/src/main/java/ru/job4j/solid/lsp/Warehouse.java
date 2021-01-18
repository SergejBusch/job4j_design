package ru.job4j.solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    List<Food> foodList = new ArrayList<>();

    @Override
    public boolean add(Food food, int index) {
        if (index < 25) {
            foodList.add(food);
            return true;
        }
        return false;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
