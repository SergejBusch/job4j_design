package ru.job4j.solid.lsp.foodstorage;

import java.util.List;

public interface Storage {

   boolean add(Food food, int index);

   List<Food> getFoodList();
}
