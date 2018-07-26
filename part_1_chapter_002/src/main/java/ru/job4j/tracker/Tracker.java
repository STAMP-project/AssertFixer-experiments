package ru.job4j.tracker;

import java.util.*;
import java.util.Arrays;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * @version 1.0
 * @since 14/06/2018
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final ArrayList<Item> items = new ArrayList<>();
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item - Новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        position++;
        return item;
    }
    /**
     * Метод реализаущий изменение заявки в хранилище.
     * @param id - ID.
     * @param newItem - Измененная заявка.
     */
    public void replace(String id, Item newItem) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                newItem.setId(id);
                items.set(items.indexOf(item), newItem);
                break;
            }
        }
    }
    /**
     * Метод реализаущий удаление заявки в хранилище.
     * @param id - ID.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
            }
        }
        return result;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Метод осуществляет поиск заявки по ID.
     * @param id - ID.
     * @return Уникальный ключ.
     */
    public Item findById(String id) {
        //поиск по id
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
     * Метод получает список заявок по имени.
     * @param name - Название заявки.
     * @return Список заявок.
     */
    public ArrayList<Item> findByName(String name) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                    result.add(item);
                }
            }
        return result;
    }
    /**
     * Метод получает список всех заявок.
     * @return Список заявок.
     */
    public ArrayList<Item> getAll() {
        return this.items;
    }

    boolean isEmpty() {
        return position > 0;
    }
}