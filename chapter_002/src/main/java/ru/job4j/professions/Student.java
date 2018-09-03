package ru.job4j.professions;

public class Student {
    String name;
    int knowlege = 100;

    public String getName() {
        return this.name;
    }
    public void skipLesson() {
        this.knowlege -= 10;
    }

}
