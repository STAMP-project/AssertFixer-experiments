package ru.avvorotov.hw1.model;

import java.util.Objects;

public class Question {

    private int id;

    private String question;

    public Question(int id, String question) {
        this.id = id;
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public int getId() {

        return id;
    }

    public String getQuestion() {
        return question;
    }
}
