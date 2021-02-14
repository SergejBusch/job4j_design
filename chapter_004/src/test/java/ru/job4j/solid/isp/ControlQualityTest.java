package ru.job4j.solid.isp;

import org.junit.Test;
import ru.job4j.solid.lsp.foodstorage.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ControlQualityTest {

    @Test
    public void whenInShop2InTrash1() {
        var p1 = new Food("a1", Date.from(Instant.now().plus(Duration.ofDays(5))),
                Date.from(Instant.now().minus(Duration.ofDays(5))), 5, "xxx");
        var p2 = new Food("a1", Date.from(Instant.now().plus(Duration.ofDays(1))),
                Date.from(Instant.now().minus(Duration.ofDays(9))), 5, "xxx");
        var p3 = new Food("a3", Date.from(Instant.now()),
                Date.from(Instant.now().minus(Duration.ofDays(12))), 5, "xxx");
        var foodService = new FoodServiceImpl();
        foodService.addFood(p1);
        foodService.addFood(p2);
        foodService.addFood(p3);
        var cq = new ControlQuality(foodService);
        cq.control();
        var storages = cq.getStorages();
        Storage shop = null;
        Storage trash = null;
        for (var s : storages) {
            if (s.getClass().getName().contains("Shop")) {
                shop = s;
            }
            if (s.getClass().getName().contains("Trash")) {
                trash = s;
            }
        }
        assertThat(shop.getFoodList().size(), is(2));
        assertThat(trash.getFoodList().size(), is(1));
        p1.setDate1(Date.from(Instant.now().plus(Duration.ofDays(6))));
        cq.resort();
        assertThat(trash.getFoodList().size(), is(2));
    }
}
