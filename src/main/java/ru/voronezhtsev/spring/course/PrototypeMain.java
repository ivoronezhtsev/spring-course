package ru.voronezhtsev.spring.course;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.voronezhtsev.spring.course.beans.Rabbit;

public class PrototypeMain {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("applicationContextPrototype.xml");
        var fedya = context.getBean("myPet", Rabbit.class);
        var rabbit = context.getBean("myPet", Rabbit.class);
        fedya.setName("Федя");
        rabbit.setName("Кроля");
        System.out.println(fedya.getName());
        System.out.println(rabbit.getName());
    }
}
