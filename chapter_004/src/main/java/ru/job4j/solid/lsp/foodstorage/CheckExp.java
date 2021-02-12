package ru.job4j.solid.lsp.foodstorage;

import java.time.Instant;
import java.util.Date;

public class CheckExp {

    public static int check(Food food) {
        double full = food.getDate2().getTime() - food.getDate1().getTime();
        double now = food.getDate2().getTime() - Date.from(Instant.now()).getTime();
        return (100 - (int) (now / full * 100));
    }
}
