package ru.job4j.solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    List<Food> foodList = new ArrayList<>();

    @Override
    public boolean add(Food food, int index) {
        if (index >= 100) {
            foodList.add(food);
            return true;
        }
        return false;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
