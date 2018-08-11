package ru.job4j.condition;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Бот который отвечает на вопросы.
 */
public class DummyBot {
    /**
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