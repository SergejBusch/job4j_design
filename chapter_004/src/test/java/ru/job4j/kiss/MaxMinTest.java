package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxMinTest {

    @Test
    public void whenOneTwoThreeThenMaxThree() {
        int result = new MaxMin().max(List.of(1, 2, 3), Comparator.naturalOrder());
        assertThat(result, is(3));
    }

    @Test
    public void whenOneTwoThreeThenMinOne() {
        int result = new MaxMin().min(List.of(1, 2, 3), Comparator.naturalOrder());
        assertThat(result, is(1));
    }
}
