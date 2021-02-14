package ru.job4j.solid.lsp.foodstorage;

public class Shop extends Storage {

    boolean check(Food food, int index) {
        if (index >= 25 && index <= 75) {
            return true;
        } else if (index > 75 && index < 100) {
            if (!food.hasSale()) {
                food.setPrice(food.getPrice() * 0.2);
                food.setSale(true);
            }
            return true;
        }
        return false;
    }
}
