package hibernate;

import hibernate.entities.Detail;
import hibernate.entities.Employee;
import org.hibernate.cfg.Configuration;


public class TestHibernate1 {

    public static void main(String[] args) {
        try (var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            var session = factory.getCurrentSession();
            // Сохранение работника с деталями
            /*var employee = new Employee("Igor", "Voronezhtsev", "UFS-Platform", 126000);
            var detail = new Detail("Moscow", "+79154322415", "i.voronezhtsev@gmail.com");
            employee.setDetail(detail);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();*/
            // Получение работника с деталями засчет каскада
            session.beginTransaction();
            var emp = session.get(Employee.class, 1);
            session.getTransaction().commit();
            System.out.println("Done.");
        }
    }
}
