package ru.job4j.professions;

public class Engineer extends Profession {
    String name;
    public String buildHouse(House house) {
        return "Строитель " + this.name + " строит " + house.name;

    }
}
