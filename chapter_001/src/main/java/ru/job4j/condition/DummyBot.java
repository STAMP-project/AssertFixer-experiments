package ru.job4j.condition;

public class DummyBot {
    /**
     * @author Sergey Petrov (sergey45684745@gmail.com)
     * Отвечает на вопросы.
     * Клммент для пуша.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
