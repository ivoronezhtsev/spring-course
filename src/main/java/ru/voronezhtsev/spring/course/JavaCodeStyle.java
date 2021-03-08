package ru.voronezhtsev.spring.course;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.voronezhtsev.spring.course.beans.Person;
import ru.voronezhtsev.spring.course.beans.Rabbit;

public class JavaCodeStyle {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var rabbit = context.getBean("rabbit", Rabbit.class);
        var person = context.getBean("person", Person.class);
        rabbit.say();
        person.callYourPet();
        context.close();
    }
}
