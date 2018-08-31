package ru.avvorotov.hw1.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.avvorotov.hw1.model.Question;
import ru.avvorotov.hw1.model.User;
import ru.avvorotov.hw1.model.UserQuestion;
import ru.avvorotov.hw1.repository.QuestionRepo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserServiceImplTest {
    QuestionRepo questionRepo;
    UserService userService;

    @Before
    public void setUp() {
        questionRepo = Mockito.mock(QuestionRepo.class);
        userService = new UserServiceImpl(questionRepo);
    }

    @Test
    public void createUser() {
        //Arrange
        UserQuestion userQuestion = new UserQuestion(1, new Question(1, "qw1"));
        Set<UserQuestion> userQuestions = new HashSet<>();
        userQuestions.add(userQuestion);
        Mockito.when(questionRepo.getUserQuestion()).thenReturn(userQuestions);
        //Act
        String frst1 = "frst1";
        String lstnm2 = "lstnm2";
        User user = userService.createUser(frst1, lstnm2);
        //Assert
        Assert.assertEquals(frst1, user.getFirstName());
        Assert.assertEquals(lstnm2, user.getLastName());
        Set<UserQuestion> questions = user.getQuestions();
        Optional<UserQuestion> first = questions.stream().findFirst();
        Assert.assertEquals(1, first.get().getId());
        Assert.assertEquals("qw1", first.get().getQuestion().getQuestion());
    }
}
