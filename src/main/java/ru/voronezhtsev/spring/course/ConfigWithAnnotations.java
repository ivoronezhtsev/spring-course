package ru.voronezhtsev.spring.course;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.voronezhtsev.spring.course.beans.Person;
import ru.voronezhtsev.spring.course.beans.Pet;

public class ConfigWithAnnotations {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("applicationContext-scan.xml");
        var person = context.getBean("person", Person.class);
        person.callYourPet();
        context.close();
    }
}
