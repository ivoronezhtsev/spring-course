package ru.voronezhtsev.spring.course.beans;

import org.springframework.stereotype.Component;

@Component
public class Rabbit implements Pet {

    private String name;

    public Rabbit() {
        System.out.println("Bean Rabbit was created");
    }

    @Override
    public void say() {
        System.out.println("Фыр-фыр");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
