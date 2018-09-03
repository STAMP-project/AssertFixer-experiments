package ru.job4j.tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        String result = tracker.getAll().get(0).getName();
        assertThat(result, is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        String result = tracker.findById(item.getId()).getName();
        assertThat(result, is("test name"));
    }
    @Test
    public void whenDeleteThenTrackerHasNoItems() {
        boolean matcher = false;
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        if (tracker.findById(item.getId()) == null) { // Проверяем удалили ли мы заявку из трекра.
            // Там она должна быть null
            matcher = true;
        }
        assertThat(matcher, is(true));
    }
    /**
     * Тесты вывода данных
     */
    /**
     * Поля для теста вывода данных
     */
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private  final String menu = new StringBuilder().append("0. Add new Item")
        .append(System.lineSeparator())
        .append("1. Show all items")
        .append(System.lineSeparator())
        .append("2. Edit item")
        .append(System.lineSeparator())
        .append("3. Delete item")
        .append(System.lineSeparator())
        .append("4. Find item by Id")
        .append(System.lineSeparator())
        .append("5. Find items by name")
        .append(System.lineSeparator())
        .append("6. Exit Program")
        .append(System.lineSeparator()).toString();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Тест на показ всех элементов
     */
    @Test
    public void whenShowAllItems() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        item.setId("01");
        item.setName("test name");
        item.setCreated(date.getTime());
        item.setDesc("desc");
        Input input = new StubInput(new String[]{"1", "6"});
        String dateText = df.format(tracker.getAll().get(0).getCreated());
        Item itemResult = tracker.getAll().get(0);
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toString()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Список всех заявок --------------")
                                .append(System.lineSeparator())
                                .append("------------ Текущая заявка --------------")
                                .append(System.lineSeparator())
                                .append("Id ")
                                .append(itemResult.getId())
                                .append(" Имя ")
                                .append(itemResult.getName())
                                .append(System.lineSeparator())
                                .append("Описание: ")
                                .append(itemResult.getDesc())
                                .append(System.lineSeparator())
                                .append("Создано ")
                                .append(dateText)
                                .append(System.lineSeparator())
                                .append("- - - - - - - - - - - - - - - - - - - - - -")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }
    /**
     * Тест на поиск по ID
     */
    @Test
    public  void whenFindByIDThenShow() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        item.setId("01");
        item.setName("test name");
        item.setCreated(date.getTime());
        item.setDesc("desc");
        Input input = new StubInput(new String[]{"4", "01", "6"});
        String dateText = df.format(tracker.getAll().get(0).getCreated());
        Item itemResult = tracker.findById("01");
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toString()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Текущая заявка --------------")
                                .append(System.lineSeparator())
                                .append("Id ")
                                .append(itemResult.getId())
                                .append(" Имя ")
                                .append(itemResult.getName())
                                .append(System.lineSeparator())
                                .append("Описание: ")
                                .append(itemResult.getDesc())
                                .append(System.lineSeparator())
                                .append("Создано ")
                                .append(dateText)
                                .append(System.lineSeparator())
                                .append("- - - - - - - - - - - - - - - - - - - - - -")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );

    }
    /**
     * Тест на поиск по имени
     */
    @Test
    public  void whenFindByNameThenShow() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        item.setId("01");
        item.setName("test name");
        item.setCreated(date.getTime());
        item.setDesc("desc");
        Input input = new StubInput(new String[]{"1", "6"});
        String dateText = df.format(tracker.getAll().get(0).getCreated());
        Item itemResult = tracker.findByName("test name").get(0);
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toString()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Список всех заявок --------------")
                                .append(System.lineSeparator())
                                .append("------------ Текущая заявка --------------")
                                .append(System.lineSeparator())
                                .append("Id ")
                                .append(itemResult.getId())
                                .append(" Имя ")
                                .append(itemResult.getName())
                                .append(System.lineSeparator())
                                .append("Описание: ")
                                .append(itemResult.getDesc())
                                .append(System.lineSeparator())
                                .append("Создано ")
                                .append(dateText)
                                .append(System.lineSeparator())
                                .append("- - - - - - - - - - - - - - - - - - - - - -")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );

    }

}
