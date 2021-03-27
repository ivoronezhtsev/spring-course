package hibernate;

import hibernate.entities.Employee;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

public class Test2 {

    private static final int IGOR_EMPLOYEE_ID = 1;

    public static void main(String[] args) throws HibernateException {

        try (var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            var session = factory.getCurrentSession();
            session.beginTransaction();
            var employee = session.get(Employee.class, IGOR_EMPLOYEE_ID);
            session.getTransaction().commit();
            System.out.println(employee);
        }
    }
}
