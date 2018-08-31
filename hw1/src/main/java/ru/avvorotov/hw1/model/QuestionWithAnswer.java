package ru.avvorotov.hw1.model;

public class QuestionWithAnswer {


    public int getId() {
        return this.question.getId();
    }

    public String getAnswer() {
        return answer;
    }

    private String answer;

    public Question getQuestion() {
        return question;
    }

    private Question question;

    public QuestionWithAnswer(int id, String question, String answer) {
        this.question = new Question(id, question);
        this.answer = answer;
    }
}
