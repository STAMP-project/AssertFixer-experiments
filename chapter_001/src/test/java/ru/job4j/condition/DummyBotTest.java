package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *DummyBotTest
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */
public class DummyBotTest {
    /**
     *Test First Condition.
     */ @Test
    public void whenGreetBot() {
         DummyBot bot = new DummyBot();
         assertThat(bot.answer("Привет, Бот."), is("Привет, умник."));

    }
    /**
     *Test Second Condition.
     */ @Test
    public void whenBuyBot() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Пока."), is("До скорой встречи."));

    }
    /**
     *Test Third Condition.
     */ @Test
    public void whenUnknownBot() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Сколько будет 2 + 2 ?"), is("Это ставит меня в тупик. Спросите другой вопрос."));

    }
}
