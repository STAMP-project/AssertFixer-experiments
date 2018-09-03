package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Collections.addAll;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа для пункта "показать все".
     */
    private static final String SHOW = "1";
    /**
     * Константа редактирования.
     */
    private static final String EDIT = "2";
    /**
     * Константа для удаления.
     */
    private static final String DELETE = "3";
    /**
     * Константа для поиска по ID.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа для поиска по имени.
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Эти переменные вынесены из метода для того, чтобы использовать их в несокольких методах
     * findByID и replace
     */
    Item itemMain = new Item();
    String idMain = new String();

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker трекер
     */

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
           } else if (SHOW.equals(answer)) {
                    this.showAll();
                } else if (EDIT.equals(answer)) {
                    this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        setItemDialog();
        System.out.println("------------ Новая заявка с getId : " + itemMain.getId() + " -----------");
    }

    /**
     * Метод показывает все заявки
     */
    private void showAll() {
        System.out.println("------------ Список всех заявок --------------");
        for (Item item : this.tracker.getAll()) {
            this.showItem(item);
        }
    }

    /**
     * Метод редактирует заявку с помощью метода поиска по ID
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        this.findById();
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long created = tracker.setDate();
        itemMain = new Item(name, desc, created);
        itemMain.setId(this.idMain);
        tracker.replace(this.idMain, this.itemMain);


    }

    /**
     * Поиск заявки по ID. Пока еще не готов. Нужно придумать, что будет если null
     */
    private  void findById() {
        idMain = this.input.ask("Введите ID заявки :");
        itemMain = tracker.findById(idMain);
        this.showItem(itemMain);
    }

    /**
     * Поиск по имени
     */
    private void findByName() {
        String name = this.input.ask("Введите имя заявки :");
        List<Item> items = new ArrayList<>();
        items.addAll(this.tracker.findByName(name));
        for (Item item: items) {
            this.showItem(item);
        }
    }

    private void deleteItem() {
        findById();
        tracker.delete(idMain);
        System.out.println("Заявка удалена");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input, new Tracker()).init();
    }

    /**
     * Меню вынесено в отдельный метод для удобства
     */
    private static void showMenu() {
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Это кусок кода используется больше одного раза
     * Он выводит на экран текущую заявку
     * @param item
     */
    private void showItem(Item item) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        String dateText = df.format(date);
        System.out.println("------------ Текущая заявка --------------");
        System.out.println("Id " + item.getId() + " Имя " + item.getName());
        System.out.println("Описание: " + item.getDesc());
        System.out.println("Создано " + dateText);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
    }

    /**
     * Этот кусок кода тоже исвпользуется больше одного раза
     * для доюавления и редактирования заявки
     */
    private  void setItemDialog() {
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long created = tracker.setDate();
        Item item = new Item(name, desc, created);
        this.tracker.add(item);
        itemMain = item; //Это такой же механизм, как общий позишн в классе трекер
                        //У нас есть где-то в памяти всегда актуальная заявка
                        // Мы обращаемся к ней, не делая из методов спагетти
    }
}