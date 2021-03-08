package ru.voronezhtsev.spring.course;

import hibernate.entities.Employee;
import org.hibernate.cfg.Configuration;

/**
 * Удаление объектов в БД
 */
public class TestHibernate5 {

    public static void main(String[] args) {
        try (var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            var session = factory.getCurrentSession();

            session.beginTransaction();
            var employee = session.get(Employee.class, 5);
            // Происходит удаление в БД
            session.delete(employee);
            session.getTransaction().commit();

            /* Удаление нескольких строк спомощью HQL
            session.beginTransaction();
            // Происходит удаление в БД
            session.createQuery("delete Employee where name='Zaur'").executeUpdate();
            session.getTransaction().commit();*/
        }
    }
}
