package ru.avvorotov.hw1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.avvorotov.hw1.model.Question;
import ru.avvorotov.hw1.model.User;
import ru.avvorotov.hw1.model.UserQuestion;
import ru.avvorotov.hw1.repository.QuestionRepo;

@Service
public class UserTestingServiceImpl implements UserTestingService {

    @Autowired
    public UserTestingServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    private QuestionService questionService;

    @Override
    public void checkAnswersUser(User user) {
        for (UserQuestion userQuestion : user.getQuestions()) {
            userQuestion.setAnswerCorrect(
                    questionService.checkQuestion(userQuestion));
        }
    }
}
