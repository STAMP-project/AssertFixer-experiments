package ru.avvorotov.hw1.model;

import java.util.Objects;

public class UserQuestion {

    private int id;

    private Question question;

    private String userAnswer;

    public void setAnswerCorrect(Boolean answerCorrect) {
        isAnswerCorrect = answerCorrect;
    }

    public Boolean getAnswerCorrect() {

        return isAnswerCorrect;
    }

    private Boolean isAnswerCorrect;

    public UserQuestion(int id, Question question) {
        this.id = id;
        this.question = question;
    }

    public Question getQuestion() {

        return question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserQuestion answer = (UserQuestion) o;
        return id == answer.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public int getId() {

        return id;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
