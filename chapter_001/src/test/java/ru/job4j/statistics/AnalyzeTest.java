package ru.job4j.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;

public class AnalyzeTest {

    @Test
    public void whenAddChangeAndDelete() {
        var analyze = new Analyze();
        var previous = List.of(
                new Analyze.User(1, "Kolya"),
                new Analyze.User(2, "Vasya"),
                new Analyze.User(3, "Nikita"));
        var current = List.of(
                new Analyze.User(1, "Masha"),
                new Analyze.User(2, "Dasha"),
                new Analyze.User(4, "Vera"));
        Assert.assertThat(analyze.diff(previous, current),
                is(new Analyze.Info(1, 2, 1)));
    }
}
