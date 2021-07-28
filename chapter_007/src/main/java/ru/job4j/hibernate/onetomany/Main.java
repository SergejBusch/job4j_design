package ru.job4j.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            CarModel one = CarModel.of("Wrangler");
            CarModel two = CarModel.of("Cherokee");
            CarModel three = CarModel.of("Compass");
            CarModel four = CarModel.of("Renegade");
            CarModel five = CarModel.of("Grand Cherokee");

            Car jeep = Car.of("Jeep");
            jeep.addAllModels(List.of(one, two,three, four, five));

            session.save(jeep);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
