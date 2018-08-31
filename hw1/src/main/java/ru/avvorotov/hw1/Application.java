package ru.avvorotov.hw1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.avvorotov.hw1.model.User;
import ru.avvorotov.hw1.model.UserQuestion;
import ru.avvorotov.hw1.service.UserService;
import ru.avvorotov.hw1.service.UserTestingService;

import java.util.Scanner;

@Component
//@PropertySource("classpath:application.properties")
public class Application {


    UserService userService;

    UserTestingService userTestingService;

    @Autowired
    public Application(UserService userService, UserTestingService userTestingService) {
        this.userService = userService;
        this.userTestingService = userTestingService;
    }




    public void run() {
        Scanner in = new Scanner(System.in);

        String firstName;
        String lastName;

        System.out.println("Введите имя пользователя: ");
        firstName = in.nextLine();
        System.out.println("Введите фамилию пользователя: ");
        lastName = in.nextLine();

        User user = userService.createUser(firstName, lastName);

        System.out.println("Начинаем тестирование.");
        System.out.println(String.format("Вам будет задано %s вопросов.", user.getQuestions().size()));
        int questionNumber = 1;
        for (UserQuestion question : user.getQuestions()) {
            System.out.println(String.format("Вопрос №%s", questionNumber));
            System.out.println(question.getQuestion().getQuestion());
            System.out.print("Введите ответ на вопрос: ");
            String answer = in.nextLine();
            question.setUserAnswer(answer);
            questionNumber++;
        }

        userTestingService.checkAnswersUser(user);

        System.out.println("Результаты тестирования.");
        questionNumber = 1;
        for (UserQuestion question : user.getQuestions()) {
            System.out.println(String.format("Вопрос №%s. Ответ: %s", questionNumber,
                    question.getAnswerCorrect() ? "Верен" : "Не верен"));
            questionNumber++;
        }
    }
}
