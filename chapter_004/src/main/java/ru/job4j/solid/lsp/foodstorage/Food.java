package ru.job4j.solid.lsp.foodstorage;

import java.util.Date;

public class Food extends Article {

    public boolean sale = false;

    public Food(String name, Date expireDate, Date createDate, double price, String discount) {
        super(name, price, discount, createDate, expireDate);
    }

    public void setSale(boolean b) {
        sale = b;
    }

    public boolean hasSale() {
        return sale;
    }
}
