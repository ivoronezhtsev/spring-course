package ru.voronezhtsev.spring.course;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.voronezhtsev.spring.course.beans.Cat;
import ru.voronezhtsev.spring.course.beans.Person;
import ru.voronezhtsev.spring.course.beans.Pet;
import ru.voronezhtsev.spring.course.beans.Rabbit;

@Configuration
public class AppConfig {

    @Bean
    public Pet rabbit() {
        System.out.println("Pet bean created");
        return new Rabbit();
    }

    @Bean
    public Pet cat() {
        System.out.println("Cat bean created");
        return new Cat();
    }

    @Bean
    public Person person(@Qualifier("cat") Pet pet) {
        return new Person(pet);
    }
}
