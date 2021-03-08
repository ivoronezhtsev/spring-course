package ru.voronezhtsev.spring.course;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.voronezhtsev.spring.course.beans.Person;

public class Main {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("applicationContext.xml");
        var person = context.getBean("myPerson", Person.class);
        person.callYourPet();

        System.out.println(person.getName());
        System.out.println(person.getAge());
        context.getBean("initDestroyPet");
        context.close();
    }

}
