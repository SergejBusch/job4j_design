package ru.job4j;

import java.math.BigDecimal;

public class User {
    private int age;
    private int index;
    private String s;

    public User(int age, int index, String s) {
        this.age = age;
        this.index = index;
        this.s = s;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %d%n", age, index);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
