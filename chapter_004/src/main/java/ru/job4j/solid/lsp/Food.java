package ru.job4j.solid.lsp;

import java.util.Date;

public class Food {
    private  String name;
    private  Date expireDate;
    private  Date createDate;
    private double price;
    private  String discount;

    public Food(String name, Date expireDate, Date createDate, double price, String discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
