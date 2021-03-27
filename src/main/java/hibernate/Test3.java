package hibernate;

import hibernate.entities.Employee;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Пример использование HQL для вывода всех работников из таблицы
 */
public class Test3 {

    private static final int IGOR_EMPLOYEE_ID = 1;

    public static void main(String[] args) throws HibernateException {

        try (var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            var session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> empList = session.createQuery("from Employee", Employee.class)
                    .getResultList();
            empList.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }
}
