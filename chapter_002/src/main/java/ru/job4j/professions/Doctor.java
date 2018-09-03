package ru.job4j.professions;

public class Doctor extends Profession {
    String name;
    public String cure(Patient patient) {
        return "Доктор " + this.name + " лечит " + patient.getName();

    }
}
