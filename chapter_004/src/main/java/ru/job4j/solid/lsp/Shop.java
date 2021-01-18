package ru.job4j.solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    List<Food> foodList = new ArrayList<>();

    @Override
    public boolean add(Food food, int index) {
        if (index >= 25 && index <= 75) {
            return foodList.add(food);
        } else if (index > 75 && index < 100) {
            food.setPrice(food.getPrice() * 0.2);
            foodList.add(food);
            return true;
        }
        return false;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
