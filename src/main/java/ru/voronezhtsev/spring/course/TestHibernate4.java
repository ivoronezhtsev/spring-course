package ru.voronezhtsev.spring.course;

import hibernate.entities.Employee;
import org.hibernate.cfg.Configuration;

/**
 * Изменение объектов в БД
 */
public class TestHibernate4 {

    public static void main(String[] args) {
        try (var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            var session = factory.getCurrentSession();

            session.beginTransaction();
            var employee = session.get(Employee.class, 1);
            System.out.println(employee);
            // Происходит апдейт в БД
            employee.setSalary(147000);

            session.getTransaction().commit();
        }
    }
}
