package ru.job4j.hibernate.manytomany;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<Book> books = new ArrayList<>();

    public static Author of(String name) {
        Author author = new Author();
        author.name = name;
        return author;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }
}
