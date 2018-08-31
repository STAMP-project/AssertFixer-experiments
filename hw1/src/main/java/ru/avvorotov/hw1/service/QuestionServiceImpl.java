package ru.avvorotov.hw1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.avvorotov.hw1.model.QuestionWithAnswer;
import ru.avvorotov.hw1.model.UserQuestion;
import ru.avvorotov.hw1.repository.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    public QuestionServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    private QuestionRepo questionRepo;

    @Override
    public boolean checkQuestion(UserQuestion userQuestion) {
        String userAnswer = userQuestion.getUserAnswer();
        QuestionWithAnswer question = questionRepo.getQuestionWithAnswers(userQuestion.getQuestion().getId());
        return userAnswer.trim().equals(question.getAnswer());
    }
}
