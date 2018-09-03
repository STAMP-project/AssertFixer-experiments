package ru.job4j.xmltutorial;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Question {
    private int id;
    private ArrayList<Answer> answers;
    private String questionname;


    public Question(int id, ArrayList<Answer> answers, String questionname) {
        this.id = id;
        this.answers = answers;
        this.questionname = questionname;
    }

    public Question(int id, ArrayList<Answer> answers) {
        this.id = id;
        this.answers = answers;
    }

    public Question() {

    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    @XmlElement
    public String getQuestionname() {
        return questionname;
    }

    public void setQuestionname(String questionname) {
        this.questionname = questionname;
    }
}
