//package ru.avvorotov.hw1.repository;
//
//import ru.avvorotov.hw1.model.Question;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class QuestionRepoMockImpl implements QuestionRepo {
//
//    private final Set<Question> questions;
//
//
//    public QuestionRepoMockImpl() {
//        questions = new HashSet<>();
//        questions.add(new Question(1,"qw1", "an1"));
//        questions.add(new Question(2,"qw2", "an2"));
//        questions.add(new Question(3,"qw3", "an3"));
//    }
//
//    @Override
//    public Set<Question> getQuestionWithAnswers() {
//        return questions;
//    }
//
//    @Override
//    public Question getQuestion(int idQuestion) {
//        return questions.stream().filter(k->k.getId() == idQuestion).findFirst().get();
//    }
//
//
//}
