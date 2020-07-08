package ru.job4j;

import org.junit.Assert;
import static org.hamcrest.core.Is.is;

public class Test {
    @org.junit.Test
    public void test() {
        Assert.assertThat(5, is(5));
    }
}
