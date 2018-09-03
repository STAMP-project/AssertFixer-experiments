package ru.job4j.tracker;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса tracker
 */

public class TrackerTest {

    /**
     * Тест добавления
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    /**
     * Тест замены
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тест поиска по ID
     */
    @Test
    public void whenSendIdThenReturnObject() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        item.setId("12345678");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    /**
     * Тест поиска по имени
     */
    @Test
    public void whenSendNameThenGetIt() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item result = tracker.findByName("test1").get(0);
        assertThat(result, is(item));
    }

    /**
     * Тест удаления элемента
     */
    @Test
    public void whenDeleteElementThenDelete() { //работает
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        item.setId("12345678");
        tracker.delete("12345678");
        assertThat(null, is(tracker.findById(item.getId())));

    }
}
