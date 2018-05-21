package com.bonjourcs.java.jc.aggregate;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description: test for aggreate operation
 * Date: 2018/5/8
 */
public class PersonListTest {

    /**
     * initialize a personList object
     *
     * @return personList
     */
    private PersonList initPersonList() {

        PersonList personList = new PersonList();

        personList.add(new Person("Kim", LocalDate.now(),
                Person.Sex.MALE, 20));
        personList.add(new Person("Jane", LocalDate.now(),
                Person.Sex.FEMALE, 22));
        personList.add(new Person("John", LocalDate.now(),
                Person.Sex.MALE, 22));
        personList.add(new Person("Alex", LocalDate.now(),
                Person.Sex.FEMALE, 22));
        personList.add(new Person("Bob", LocalDate.now(),
                Person.Sex.MALE, 14));

        return personList;

    }

    @Test
    public void testPrintPeronName() {
        System.out.println("Print each person's name: ");
        PersonList personList = initPersonList();
        personList.printPeronName();
    }

    @Test
    public void testPrintMaleName() {
        System.out.println("Only print male's name: ");
        PersonList personList = initPersonList();
        personList.printMaleName();
    }

    @Test
    public void testGetMaleAverageAge() {
        PersonList personList = initPersonList();
        System.out.println("Average age for male: " + personList.getMaleAverageAge());
    }

    @Test
    public void testGetTotalAge() {
        PersonList personList = initPersonList();
        System.out.println("Total age: " + personList.getTotalAge());
    }

    @Test
    public void testAverageAge() {
        PersonList personList = initPersonList();
        System.out.println("Average age: " + personList.getAverageAge());
    }

    @Test
    public void testSortByGender() {

        PersonList personList = initPersonList();

        Map<Person.Sex, List<Person>> sortedMap
                = personList.sortByGender();

        // show elements
        System.out.println("Males: ");
        sortedMap.get(Person.Sex.MALE).forEach(System.out::println);
        System.out.println("Females: ");
        sortedMap.get(Person.Sex.FEMALE).forEach(System.out::println);

    }

    @Test
    public void testNamesByGender() {

        PersonList personList = initPersonList();

        Map<Person.Sex, List<String>> sortedMap
                = personList.namesByGender();

        System.out.println("Males: ");
        sortedMap.get(Person.Sex.MALE).forEach(System.out::println);
        System.out.println("Females: ");
        sortedMap.get(Person.Sex.FEMALE).forEach(System.out::println);

    }
    
    @Test
    public void testAgeByGender(){

        PersonList personList = initPersonList();

        Map<Person.Sex, Integer> sortedMap
                = personList.totalAgeByGender();

        System.out.println("Males' total age: " + sortedMap.get(Person.Sex.MALE));
        System.out.println("Females' total age: " + sortedMap.get(Person.Sex.FEMALE));

    }
}