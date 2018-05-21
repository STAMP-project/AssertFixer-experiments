package com.bonjourcs.java.jc.aggregate;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author Liang Chenghao
 * Description: class Person to invoke aggregate operation
 * Date: 2018/5/8
 */
@Data
public class Person {

    /**
     * name of person
     */
    private String name;
    /**
     * mark date of person
     */
    private LocalDate markDate;
    /**
     * sex of person
     */
    private Sex sex;
    /**
     * age of person
     */
    private int age;

    public Person() {
    }

    public Person(String name, LocalDate markDate, Sex sex, int age) {
        this.name = name;
        this.markDate = markDate;
        this.sex = sex;
        this.age = age;
    }

    /**
     * gender enumeration
     */
    public enum Sex {
        MALE, FEMALE
    }

}
