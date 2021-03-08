package ru.voronezhtsev.spring.course.beans;

public class InitDestroyPet implements Pet {

    private void init() {
        System.out.println("Init method");
    }

    private void destroy() {
        System.out.println("Destroy method");
    }

    @Override
    public void say() {
        System.out.println(getClass().getName());
    }
}
