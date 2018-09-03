package ru.job4j.tracker;
import java.sql.Time;
import java.util.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Список для хранения заявок.
     */
    private final List<Item> items = new ArrayList<Item>();
    /**
     * Это получает номер ячейки массива при вызове метода
     * findById();
     */
    private int idPosition = 0;

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Рандомная константа
     */
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     *Метод должен удалить ячейку в списке this.items.
     * @param id
     */

    public void delete(String id) {
        if (findById(id) != null) {
            this.items.remove(idPosition);
        }
    }

    /**
     * редактирование заявок
     * @param id
     * @param item
     */

    public void replace(String id, Item item) {
        Tracker tracker = new Tracker();
        tracker.findById(id);
        this.items.set(idPosition, item);
    }

    /**
     * получение списка всех заявок
     * @return
     */

    public List<Item> getAll() {
        if (!items.isEmpty()) {
            return this.items;
        }
        return new ArrayList<Item>();
    }
    /**
     * получение списка по имени
     * @param key
     * @return
     */

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item: items) {
            if ((key.equals(item.getName()))) {
                result.add(item);
            }
        }
        return  result;
    }

    /**
     * получение заявки по id
     * @param id
     * @return
     */

    protected Item findById(String id) {
        Item result = null;
        for (Item item: items) {
            if (id.equals(item.getId())) {
                result = item;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание.
     * Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
     String generateId() {
        long id =  Math.abs((byte) RN.nextLong());
        //Реализовать метод генерации.
        return Long.toString(id);
    }
    protected  long setDate() {
        Date date = new Date();
        return date.getTime();
    }
}
