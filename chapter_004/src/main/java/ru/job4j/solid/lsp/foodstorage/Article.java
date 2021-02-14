package ru.job4j.solid.lsp.foodstorage;

import java.util.Date;
import java.util.Objects;

public abstract class Article {
    private String name;
    private double price;
    private String discount;
    private Date date1;
    private Date date2;

    public Article(String name, double price, String discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public Article(String name, double price, String discount, Date date1, Date date2) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.date1 = date1;
        this.date2 = date2;
    }

    public String getName() {
        return name;
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

    public Date getDate1() {
        return date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", discount='" + discount + '\'' +
                ", date1=" + date1 +
                ", date2=" + date2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Article article = (Article) o;

        if (Double.compare(article.price, price) != 0) {
            return false;
        }
        if (!Objects.equals(name, article.name)) {
            return false;
        }
        if (!Objects.equals(discount, article.discount)) {
            return false;
        }
        if (!Objects.equals(date1, article.date1)) {
            return false;
        }
        return Objects.equals(date2, article.date2);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (date1 != null ? date1.hashCode() : 0);
        result = 31 * result + (date2 != null ? date2.hashCode() : 0);
        return result;
    }
}
