package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUISQL {

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
     * Хранилище заявок.
     */
    private final TrackerSQL tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   data input.
     * @param tracker tracker
     */

    public StartUISQL(Input input, TrackerSQL tracker) {
        this.input = input;
        this.tracker = tracker;
    }


    public void init() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            String answer = this.input.ask("Choose an option... : ");
            if (ADD.equals(answer)) {
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
        System.out.println("------------ Add new Item --------------");
        setItemDialog(new Item());
        System.out.println("------------ Item has been added  -----------");
    }

    /**
     * Метод показывает все заявки
     */
    private void showAll() {
        System.out.println("------------ All items --------------");
        for (Item item : this.tracker.getAll()) {
            this.showItem(item);
        }
    }

    /**
     * Метод редактирует заявку с помощью метода поиска по ID
     */
    private void editItem() {
        Item item = new Item();
        String id = new String();
        System.out.println("------------ Edit item --------------");
        this.findById();
        String name = this.input.ask("Enter item name :");
        String desc = this.input.ask("Enter item description :");
        long created = tracker.setDate();
        item = new Item(name, desc, created);
        item.setId(id);
        tracker.replace(id, item);


    }

    /**
     * Поиск заявки по ID.
     */
    private void findById() {
        Item item = new Item();
        String id = new String();
        id = this.input.ask("Enter item ID :");
        item = tracker.findById(id);
        this.showItem(item);
        this.showComments(item);
    }

    /**
     * Поиск по имени
     */
    private void findByName() {
        String name = this.input.ask("Enter Item name:");
        List<Item> items = new ArrayList<>();
        items.addAll(this.tracker.findByName(name));
        for (Item item : items) {
            this.showItem(item);
        }
    }

    private void deleteItem() {
        String id = new String();
        id = this.input.ask("Enter item ID:");
        tracker.delete(id);
        System.out.println("Item has been deleted");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUISQL(input, new TrackerSQL(new ConfigReader())).init();
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
     *
     * @param item
     */
    private void showItem(Item item) {
        Date date = new Date(item.getCreated());
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        String dateText = df.format(date);
        System.out.println("------------ Current item--------------");
        System.out.println("ID " + item.getId() + " name " + item.getName());
        System.out.println("Descritption: " + item.getDesc());
        System.out.println("Created " + dateText);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
    }

    /**
     * Этот кусок кода тоже исвпользуется больше одного раза
     * для доюавления и редактирования заявки
     */
    private void setItemDialog(Item item) {
        String name = this.input.ask("Enter item name :");
        String desc = this.input.ask("Enter item description :");
        long created = tracker.setDate();
        item = new Item(name, desc, created);
        this.addComments(item);
        this.tracker.add(item);
    }

    /**
     * This method shows all the comment from the table
     */
    private void showComments(Item item) {
        int counter = 1;
        if (item.getComments() != null && !item.getComments().isEmpty()) {
            for (String string : item.getComments()) {
                System.out.println();
                System.out.println(String.format("Comment %d", counter));
                System.out.println(string);
                System.out.println();
                counter++;
            }
        }
    }

    private void addComments(Item item) {
        String suggestion = this.input.ask("Would you like to add some comments[y/n]");
        String exit = "n";
        List<String> result = new ArrayList<>();
        while (!exit.equals("y") && suggestion.equals("y")) {
            result.add(this.input.ask("Enter a comment..."));
            exit = this.input.ask("Enter \"y\" to exit...");
        }
        if (!result.isEmpty()) {
            item.setComments(result);
        }
    }

}