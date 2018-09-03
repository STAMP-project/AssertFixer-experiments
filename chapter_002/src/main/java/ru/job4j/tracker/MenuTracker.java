package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод возвращает массив чисел, которые введет пользователь
     */
    public int[] getRange() {
        int[] ranges = new int[this.actions.size()];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = i;
        }
        return ranges;

    }

    public void show() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
     static void showItem(Item item) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        String dateText = df.format(date);
        System.out.println("Id " + item.getId() + " Имя " + item.getName());
        System.out.println("Описание: " + item.getDesc());
        System.out.println("Создано " + dateText);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
    }


    public void fillActions() {
        this.actions.add(0, new AddItem(0, "Add the new item"));
        this.actions.add(1, new ShowAllItems(1, "Show all items"));
        this.actions.add(2, new EditItem(2, "Edit item"));
        this.actions.add(3, new DeleteItem(3, "Delete item"));
        this.actions.add(4, new FindByIdItem(4, "Find item by Id"));
        this.actions.add(5, new FindByNameItems(5, "Find items by name"));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    private static class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки");
            String desc = input.ask("Введите описание");
            long created = tracker.setDate();
            Item item = new Item(name, desc, created);
            tracker.add(item);
        }
    }

    private static class ShowAllItems extends BaseAction {
        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Список всех заявок --------------");
            for (Item item : tracker.getAll()) {
                    MenuTracker.showItem(item);
            }
        }
    }

     class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите Id заявки: ");
            Item item = tracker.findById(id);
            if (item != null) {
                tracker.delete(id);
                System.out.println("------------ Заявка удалена --------------");
            }
        }
    }


    private class FindByIdItem extends BaseAction {
        public FindByIdItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите Id заявки: ");
            Item item = tracker.findById(id);
            if (item != null) {
                showItem(item);
            }
        }

    }
    class FindByNameItems extends BaseAction {
        public FindByNameItems(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки: ");
            List<Item> items = tracker.findByName(name);
            for (Item item : items) {
                if (item != null) {
                    showItem(item);
                }
            }
        }
    }
}
/**
 * Внешений класс внутри файла класса MenuTracker
 */
class EditItem extends BaseAction {
    public EditItem(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите Id заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("------------ Текущая заявка --------------");
            MenuTracker.showItem(item);
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            long created = tracker.setDate();
            item.setName(name);
            item.setDesc(desc);
            item.setCreated(created);
            System.out.println("------------ Заявка изменена --------------");
            System.out.println("------------ Текущая заявка --------------");
            MenuTracker.showItem(item);
        }
    }

}


