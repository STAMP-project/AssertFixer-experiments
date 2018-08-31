//package ru.avvorotov.hw1;
//
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import ru.avvorotov.hw1.service.UserTestingServiceImpl;
//
//public class hw1Test {
//
//    private UserTestingServiceImpl checkAnswer;
//    private ClassPathXmlApplicationContext context;
//
//    @Before
//    public void before() {
//        context = new ClassPathXmlApplicationContext("/spring-context.xml");
//        checkAnswer = (UserTestingServiceImpl)context.getBean("checkAnswer");
//    }
//
//    @Test
//    public void hw1TrueTest() {
//        boolean result1 = checkAnswer.check(new UserAnswer(1, checkAnswer.getQuestion().getId(), "an1"));
//        boolean result2 = checkAnswer.check(new UserAnswer(2, checkAnswer.getQuestion().getId(), "an2"));
//
//        Assert.assertTrue(result1);
//        Assert.assertTrue(result2);
//    }
//
//    @Test
//    public void hw1FalseTest() {
//
//        boolean result1 = checkAnswer.check(new UserAnswer(1, checkAnswer.getQuestion().getId(), "anfalse"));
//        boolean result2 = checkAnswer.check(new UserAnswer(2, checkAnswer.getQuestion().getId(), "an2"));
//
//        Assert.assertFalse(result1);
//        Assert.assertTrue(result2);
//    }
//
//    @After
//    public void after(){
//        context.close();
//    }
//
//}
