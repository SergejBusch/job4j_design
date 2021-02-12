package ru.job4j.solid.lsp.foodstorage;

import java.util.List;

public interface FoodService {
    boolean addFood(Food food);

    boolean removeFood(Food food);

    List<Food> getFood();
}
