package hibernate;

import hibernate.entities.Employee;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) throws HibernateException {
            var factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();

            var session = factory.getCurrentSession();
            var emp = new Employee("Igor", "Voronezhtsev", "Test Tools", 126000);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
    }
}
