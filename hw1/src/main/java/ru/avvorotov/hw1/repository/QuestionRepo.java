package ru.avvorotov.hw1.repository;

import ru.avvorotov.hw1.model.QuestionWithAnswer;
import ru.avvorotov.hw1.model.UserQuestion;

import java.util.Set;

public interface QuestionRepo {

    Set<UserQuestion> getUserQuestion();

    QuestionWithAnswer getQuestionWithAnswers(int idQuestion);
}