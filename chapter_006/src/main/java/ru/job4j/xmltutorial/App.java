package ru.job4j.xmltutorial;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Answer> answers = new ArrayList<>();
        answers.add(new Answer(101, "Java is a programming language", "ravi"));
        answers.add(new Answer(10, "Java is a platform", "john"));
        Question question = new Question(1, answers, "What is java");
        StringWriter sw = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.marshal(question, sw);
            String xmlString = sw.toString();
            System.out.println(xmlString);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
