package ru.voronezhtsev.spring.course.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private Pet pet;
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Person setName called");
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        System.out.println("Person setAge called");
        this.age = age;
    }

    @Autowired
    public Person(@Qualifier("rabbit") Pet pet) {
        this.pet = pet;
        System.out.println("Создаем персона");
    }

    public void setPet(Pet pet) {
        System.out.println("Установили животное");
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Привет мое любимое животное");
        pet.say();
    }
}
