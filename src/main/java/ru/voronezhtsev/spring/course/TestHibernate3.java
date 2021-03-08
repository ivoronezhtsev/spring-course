package ru.voronezhtsev.spring.course;

import org.hibernate.cfg.Configuration;

public class TestHibernate3 {

    public static void main(String[] args) {
        try (var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()) {
            var session = factory.getCurrentSession();

            session.beginTransaction();
            // HQL запрос
            var employees = session.createQuery("from Employee")
                    .getResultList();
            employees.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
