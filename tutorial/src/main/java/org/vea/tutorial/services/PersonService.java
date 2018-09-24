package org.vea.tutorial.services;

import org.vea.tutorial.controllers.values.Person;

import java.util.Map;


public interface PersonService {
    Map<String,Person> getPersonMap();

    Person[] getPersonArray();

    Person getPerson();
}
