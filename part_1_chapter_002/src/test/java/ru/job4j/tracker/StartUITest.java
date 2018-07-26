package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final Tracker tracker = new Tracker();
    private final Item one = new Item("test 1", "desc 1", 1);
    private final Item two = new Item("test 2", "desc 2", 12);
    private final Item[] test = new Item[]{};
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    public String l = System.lineSeparator();


    @Before
    public void inputdata() {
        tracker.add(one);
        tracker.add(two);
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenAddItem() {
        Input input = new StubInput(new String[]{"1", "testname", "desc", "да"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is("Редактор заявок"
                + l + "Пожалуйста выберете действие:"
                + l + "1. Добавить заявку"
                + l + "2. Редактировать заявку"
                + l + "3. Удалить заявку"
                + l + "4. Текущие заявки"
                + l + "5. Поиск заявки по ID"
                + l + "6. Поиск заявки по названию"
                + l + "7. Выйти"
                + l + "Заявка с ID: " + tracker.getAll().get(2).getId() + " создана"
                + l));
    }

    @Test
    public void whenUpdateItem() {
        Input input = new StubInput(new String[]{"2", one.getId(), "replace", "replace", "нет", "4", "да"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is("Редактор заявок"
                + l + "Пожалуйста выберете действие:"
                + l + "1. Добавить заявку"
                + l + "2. Редактировать заявку"
                + l + "3. Удалить заявку"
                + l + "4. Текущие заявки"
                + l + "5. Поиск заявки по ID"
                + l + "6. Поиск заявки по названию"
                + l + "7. Выйти"
                + l + "Редактирование заявки"
                + l + "Заявка с ID:" + one.getId() + " обновлена"
                + l + "Редактор заявок"
                + l + "Пожалуйста выберете действие:"
                + l + "1. Добавить заявку"
                + l + "2. Редактировать заявку"
                + l + "3. Удалить заявку"
                + l + "4. Текущие заявки"
                + l + "5. Поиск заявки по ID"
                + l + "6. Поиск заявки по названию"
                + l + "7. Выйти"
                + l + "Текущие заявки:"
                + l + one.getId() + " replace replace"
                + l + two.getId() + " test 2 desc 2"
                + l));
    }

    @Test
    public void whenDeleteItem() {
        Input input = new StubInput(new String[]{"3", one.getId(), "нет", "4", "да"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is("Редактор заявок"
                + l + "Пожалуйста выберете действие:"
                + l + "1. Добавить заявку"
                + l + "2. Редактировать заявку"
                + l + "3. Удалить заявку"
                + l + "4. Текущие заявки"
                + l + "5. Поиск заявки по ID"
                + l + "6. Поиск заявки по названию"
                + l + "7. Выйти"
                + l + "Удаление заявки"
                + l + "Заявка с ID: " + one.getId() + " удалена"
                + l + "Редактор заявок"
                + l + "Пожалуйста выберете действие:"
                + l + "1. Добавить заявку"
                + l + "2. Редактировать заявку"
                + l + "3. Удалить заявку"
                + l + "4. Текущие заявки"
                + l + "5. Поиск заявки по ID"
                + l + "6. Поиск заявки по названию"
                + l + "7. Выйти"
                + l + "Текущие заявки:"
                + l + two.getId() + " test 2 desc 2"
                + l));
    }

    @Test
    public void whenGetAllItems() {
        Input input = new StubInput(new String[]{"4", "да"});
        new StartUI(input, tracker).init();
        Item[] test = new Item[]{one, two};
        assertThat(new String(this.out.toByteArray()), is("Редактор заявок"
                + l + "Пожалуйста выберете действие:"
                + l + "1. Добавить заявку"
                + l + "2. Редактировать заявку"
                + l + "3. Удалить заявку"
                + l + "4. Текущие заявки"
                + l + "5. Поиск заявки по ID"
                + l + "6. Поиск заявки по названию"
                + l + "7. Выйти"
                + l + "Текущие заявки:"
                + l + one.getId() + " test 1 desc 1"
                + l + two.getId() + " test 2 desc 2"
                + l));
    }

    @Test
    public void whenFindId() {
        Input input = new StubInput(new String[]{"5", one.getId(), "да"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is("Редактор заявок"
                + l + "Пожалуйста выберете действие:"
                + l + "1. Добавить заявку"
                + l + "2. Редактировать заявку"
                + l + "3. Удалить заявку"
                + l + "4. Текущие заявки"
                + l + "5. Поиск заявки по ID"
                + l + "6. Поиск заявки по названию"
                + l + "7. Выйти"
                + l + "Поиск заявки по ID"
                + l + one.getId() + " test 1 desc 1"
                + l));
    }

    @Test
    public void whenFindByName() {
        Input input = new StubInput(new String[]{"6", two.getName(), "да"});
        new StartUI(input, tracker).init();
        Item[] test = new Item[]{two};
        assertThat(new String(this.out.toByteArray()), is("Редактор заявок"
                + l + "Пожалуйста выберете действие:"
                + l + "1. Добавить заявку"
                + l + "2. Редактировать заявку"
                + l + "3. Удалить заявку"
                + l + "4. Текущие заявки"
                + l + "5. Поиск заявки по ID"
                + l + "6. Поиск заявки по названию"
                + l + "7. Выйти"
                + l + "Поиск заявки по названию"
                + l + two.getId() + " test 2 desc 2"
                + l));
    }
}