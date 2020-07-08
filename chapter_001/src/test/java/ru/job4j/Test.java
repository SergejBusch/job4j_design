package ru.job4j;

import org.junit.Assert;
import ru.job4j.test.Main;

import static org.hamcrest.core.Is.is;

public class Test {
    @org.junit.Test
    public void test() {
        Assert.assertThat(Main.sum(2, 3), is(5));
    }
}
