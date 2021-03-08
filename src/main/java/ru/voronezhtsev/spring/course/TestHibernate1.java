package ru.voronezhtsev.spring.course;

import hibernate.entities.Employee;
import org.hibernate.cfg.Configuration;

public class TestHibernate1 {

    public static void main(String[] args) {

        try (var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            var session = factory.getCurrentSession();
            var employee = new Employee("Igor", "Voronezhtsev", "sbt", 126000);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }
}
