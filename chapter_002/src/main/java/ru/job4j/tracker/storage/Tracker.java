package ru.job4j.tracker.storage;

import ru.job4j.tracker.model.Item;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Tracker.
 *
 * @author Svetlana Egorova (s.sosenkova@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    //private Item[] items = new Item[100];
    private ArrayList<Item> items = new ArrayList<>(100);
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    private static final Random RN = new Random();

    /**
     * Метод add. Добавление заявок.
     *
     * @param item новая заявка.
     * @return переданную заявку.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        this.position++;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод findById. Получение заявки по Id. проверяет в цикле все элементы массива this.items, сравнивая id с аргументом String id.
     *
     * @param id Идентификатор item-а.
     * @return Возвращает найденный Item. Если Item не найден - возвращает null.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод findAll. Получение списка всех заявок.
     *
     * @return Возвращает копию массива this.items без null элементов;
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        result.addAll(this.items);
        return result;
    }

    /**
     * Метод replace. Редактирование заявок. Заменяет ячейку в массиве this.items. (Для этого необходимо найти ячейку в массиве по id).
     *
     * @param id   Id заявки, которую необходимо заменить.
     * @param item На что необходимо заменить заявку.
     */
    public boolean replace(String id, Item item) {
        boolean answer = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.set(i, item);
                this.items.get(i).setId(id);
                answer = true;
                break;
            }
        }
        return answer;
    }

    /**
     * Метод delete. Удаление заявок. Удаляет ячейку в массиве this.items. (Для этого необходимо найти ячейку в массиве по id.  Далее сместить все значения справа от удаляемого элемента - на одну ячейку влево с помощью System.arrayCopy()).
     *
     * @param id Идентификатор item-а.
     */
    public boolean delete(String id) {
        boolean answer = false;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                this.items.remove(item);
                answer = true;
                break;
            }
        }
        return answer;
    }

    /**
     * Метод findByName. Получение списка по имени. Проверяет в цикле все элементы массива this.items, сравнивая name (используя метод getName класса Item) с аргументом метода String key. Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его;
     *
     * @param key Предположительное имя item-а.
     * @return item, с которым совпало имя.
     */
    public List<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result.add(item);
                item.setId(item.getId());
            }
        }
        return result;
    }
}