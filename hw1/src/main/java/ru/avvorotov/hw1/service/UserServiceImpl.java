package ru.avvorotov.hw1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.avvorotov.hw1.model.User;
import ru.avvorotov.hw1.repository.QuestionRepo;

@Service
public class UserServiceImpl implements UserService {

    private int userId = 1;

    private QuestionRepo questionRepo;

    @Autowired
    public UserServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public User createUser(String firstName, String lastName) {
        User user = new User(userId, firstName, lastName);
        user.setQuestion(questionRepo.getUserQuestion());
        userId++;
        return user;
    }


}
