package ru.job4j.professions;

public class Teacher {
    String name;
    public String teachStudent(Student student) {
        return "Учитель " + this.name + " учит " + student.name;
    }
}
