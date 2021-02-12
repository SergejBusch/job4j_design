package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class FoodServiceImpl implements FoodService {
    List<Food> foodList = new ArrayList<>();

    @Override
    public boolean addFood(Food food) {
        return foodList.add(food);
    }

    @Override
    public boolean removeFood(Food food) {
        return foodList.remove(food);
    }

    @Override
    public List<Food> getFood() {
        return foodList;
    }
}
