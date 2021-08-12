package ru.job4j.hibernate.hql;

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

//            Candidate first = Candidate.of(0, "Bob", 3, 5);
//            Candidate second = Candidate.of(0, "John", 1, 3);
//            Candidate third = Candidate.of(0, "Mike", 8, 10);

//            session.save(first);
//            session.save(second);
//            session.save(third);

            var selectAll = session.createQuery("from Candidate");

            var selectOne = session.createQuery("from Candidate c where c.id = :Id");
            selectOne.setParameter("Id", 1);

            var update = session.createQuery(
                    "update Candidate c set c.name = :newName, c.experience = :exp, c.salary = :newSalary where c.id = : Id")
                    .setParameter("newName", "Peter")
                    .setParameter("exp", 99)
                    .setParameter("newSalary", 999)
                    .setParameter("Id", 2)
                    .executeUpdate();

            var delete = session.createQuery(
                    "delete from Candidate c where c.id = : Id")
                    .setParameter("Id", 3)
                    .executeUpdate();



            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
