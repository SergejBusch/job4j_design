package ru.job4j.hibernate.manytomany;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Author first = Author.of("Pushkin");
            Author second = Author.of("Shakespeare");

            Book one = Book.of("Harry Potter");
            Book two = Book.of("Marry Poppins");

            first.addBook(one);
            first.addBook(two);
            second.addBook(two);

//            session.persist(first);
//            session.persist(second);

            var author = session.get(Author.class, 11);
            session.remove(author);
            session.getTransaction().commit();


            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
