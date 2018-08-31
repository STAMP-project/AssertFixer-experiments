package ru.avvorotov.hw1.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.avvorotov.hw1.model.Question;
import ru.avvorotov.hw1.model.User;
import ru.avvorotov.hw1.model.UserQuestion;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTestingServiceImplTest {


    QuestionService mockQuestionService;
    UserTestingService userTestingService;

    @Before
    public void before() {
        mockQuestionService = mock(QuestionService.class);
        userTestingService = new UserTestingServiceImpl(mockQuestionService);
    }

    @Test
    public void testSuccess() {
        when(mockQuestionService.checkQuestion(any(UserQuestion.class))).thenReturn(true);

        User user = new User(1, "name1", "last1");

        UserQuestion userQuestion1 = new UserQuestion(1, new Question(1, "qw1"));

        Set<UserQuestion> userQuestions = new HashSet<>();
        userQuestions.add(userQuestion1);

        user.setQuestion(userQuestions);

        userTestingService.checkAnswersUser(user);


        Assert.assertTrue(user.getQuestions().stream().allMatch(k-> k.getAnswerCorrect()));



    }


}
