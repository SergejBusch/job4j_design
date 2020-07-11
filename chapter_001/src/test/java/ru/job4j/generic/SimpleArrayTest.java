package ru.job4j.generic;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

import java.util.Iterator;
import java.util.List;

public class SimpleArrayTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWhenArrayIsFull() {
        var simpleArray = new SimpleArray<Integer>(3);
        simpleArray.add(1);
        simpleArray.add(1);
        simpleArray.add(1);
        simpleArray.add(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveAndIndexOutOfRange() {
        var simpleArray = new SimpleArray<Integer>(3);
        simpleArray.remove(3);
    }

    @Test()
    public void whenSet() {
        var simpleArray = new SimpleArray<String>(3);
        simpleArray.add("a");
        simpleArray.set(0, "b");
        Assert.assertThat(simpleArray.get(0), is("b"));
    }

    @Test()
    public void whenAddAndRemove() {
        var simpleArray = new SimpleArray<Integer>(3);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.remove(1);
        simpleArray.add(4);
        Assert.assertThat(new Integer[] {
                simpleArray.get(0),
                simpleArray.get(1),
                simpleArray.get(2)}, is(new Integer[] {1, 3, 4}));
    }

    @Test()
    public void whenGetIterator() {
        var simpleArray = new SimpleArray<String>(2);
        simpleArray.add("a");
        Iterator<String> it = simpleArray.iterator();
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is("a"));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), nullValue());
        Assert.assertThat(it.hasNext(), is(false));
    }
}

