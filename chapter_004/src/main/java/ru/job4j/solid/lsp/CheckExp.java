package ru.job4j.solid.lsp;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CheckExp {

    public static int check(Food food) {
        double full = food.getExpireDate().getTime() - food.getCreateDate().getTime();
        double now = food.getExpireDate().getTime() - Date.from(Instant.now()).getTime();
        return (100 - (int) (now / full * 100));
    }
}
