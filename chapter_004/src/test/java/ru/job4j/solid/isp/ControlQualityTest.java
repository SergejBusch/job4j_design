package ru.job4j.solid.isp;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import ru.job4j.solid.lsp.ControlQuality;
import ru.job4j.solid.lsp.Food;
import ru.job4j.solid.lsp.Storage;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

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
        var cq = new ControlQuality(List.of(p1, p2, p3));
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
    }
}
