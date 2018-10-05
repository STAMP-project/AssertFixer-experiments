package ru.job4j.tracker.action;

import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.storage.Tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Внешний внутренний класс Exit.
 */
class Exit implements UserAction {
    private final StartUI ui;

    Exit(StartUI ui) {
        this.ui = ui;
    }

    public int key() {
        return 6;
    }

    public String info() {
        return "6 : Exit.";
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Время выходить. До свидания!");
        this.ui.stop();
    }
}

/**
 * Внешний внутренний класс EditItem.
 */
class EditItem extends BaseAction {
    public EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter the task's id : ");
        if (tracker.findById(id) != null) {
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Заявка отредактирована.");
            }
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
    }
}

/**
 * Внешний внутренний класс FindByName.
 */
class FindByName extends BaseAction {
    public FindByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки, которую нужно найти.");
        List<Item> allItems = tracker.findByName(name);
        if (tracker.findByName(name).isEmpty()) {
            System.out.println("Заявок с таким именем не обнаружено.");
        } else {
            for (Item item : allItems) {
                if (item != null) {
                    System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDescription()));
                }
            }
        }
    }
}

/**
 * UserAction - те действия, которые выполняет программа.
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>(7);

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод fillActions, заполняет наши данные.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(this.new AddItem(0, "Add an item."));
        this.actions.add(new MenuTracker.ShowItems(1, "Show all items."));
        this.actions.add(new EditItem(2, "Edit item."));
        this.actions.add(this.new DeleteItem(3, "Delete an item."));
        this.actions.add(new MenuTracker.FindItemById(4, "Find an Item by ID."));
        this.actions.add(new FindByName(5, "Find items by name."));
        this.actions.add(new Exit(ui));
    }

    /**
     * Метод, который будет выполнять наше действие, которое выбрал пользователь.
     *
     * @param key действие, которое записано в наш массив.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public List<Integer> range() {
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < actions.size(); i++) {
            range.add(i);
        }
        return range;
    }

    /**
     * Внутренний класс AddItem.
     * Он не статический.
     */
    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите описание заявки : ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    /**
     * Внутренний, но уже статический класс ShowItems.
     */
    private static class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                if (item != null) {
                    System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDescription()));
                }
            }
        }
    }

    /**
     * Внутренний не статический класс DeleteItem.
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую следует удалить.");
            if (tracker.delete(id)) {
                System.out.println("Заявка удалена.");
            } else {
                System.out.println("Заявка с таким id не найдена.");
            }
        }
    }

    /**
     * Внутренний статический класс FindItemById
     */
    private static class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую нужно найти.");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(String.format("%s, %s, %s", item.getId(), item.getName(), item.getDescription()));
            } else {
                System.out.println("Заявка с такми id не найдена.");
            }
        }
    }
}