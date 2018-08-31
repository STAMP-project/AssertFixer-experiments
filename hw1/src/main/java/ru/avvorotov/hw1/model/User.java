package ru.avvorotov.hw1.model;

import java.util.Set;

public class User {

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<UserQuestion> getQuestions() {
        return question;
    }

    private int id;
    private String firstName;
    private String lastName;
    private Set<UserQuestion> question;

    public void setQuestion(Set<UserQuestion> question) {
        this.question = question;
    }

    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
