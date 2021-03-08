package ru.voronezhtsev.spring.course;

import hibernate.entities.Employee;
import org.hibernate.cfg.Configuration;

public class TestHibernate2 {

    public static void main(String[] args) {
        try (var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            // Добавление нового работника
            var session = factory.getCurrentSession();
            var employee = new Employee("Zaur", "Tregulov", "IT", 750);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            // Получение нового работника (получаем новую сессию, т.к. старую закрыли коммитом!)
            var id = employee.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            var emp = session.get(Employee.class, id);
            session.getTransaction().commit();
            System.out.println(emp);
        }
    }
}
