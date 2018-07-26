package ru.job4j.tracker;

import java.util.ArrayList;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private ArrayList<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillAction() {
        actions.add(new AddItem(1, "Добавить заявку"));
        actions.add(new EditItem(2, "Редактировать заявку"));
        actions.add(new DeleteItem(3, "Удалить заявку"));
        actions.add(new GetAll(4, "Текущие заявки"));
        actions.add(new FindByID(5, "Поиск заявки по ID"));
        actions.add(new FindByName(6, "Поиск заявки по названию"));
        actions.add(new Exit(7, "Выйти"));
    }

    public void select(int key) {
        actions.get(key - 1).execute(this.input, this.tracker);
    }

    public void show() {
        System.out.println("Редактор заявок");
                System.out.println("Пожалуйста выберете действие:");
                for (UserAction action : this.actions) {
                    if (action != null) {
                        System.out.println(action.info());
            }
        }
    }

    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Пожалуйста введите имя:");
            String description = input.ask("Пожалуйста введите описание заявки:");
            Item item = new Item(name, description, System.currentTimeMillis());
            tracker.add(item);
            System.out.println("Заявка с ID: " + item.getId() + " создана");
        }
    }

    public class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            if (tracker.isEmpty()) {
                System.out.println("Редактирование заявки");
                String id = input.ask("Введите ID заявки:");
                if (tracker.findById(id) != null) {
                    String name = input.ask("Введите название заявки:");
                    String desc = input.ask("Введите описание заявки:");
                    Item item = new Item(name, desc, System.currentTimeMillis());
                    tracker.replace(id, item);
                    System.out.println("Заявка с ID:" + item.getId() + " обновлена");
                } else {
                    System.out.println("Заявки с ID:" + id + " не существует");
                }
            } else {
                System.out.println("В настоящее время заявок нет");
            }
        }
    }

    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            if (tracker.isEmpty()) {
                System.out.println("Удаление заявки");
                String id = input.ask("Введите ID заявки:");
                if (tracker.delete(id)) {
                    System.out.println("Заявка с ID: " + id + " удалена");
                } else {
                    System.out.println("Заявка с ID:" + id + " не найдена");
                }
            } else {
                System.out.println("В настоящее время заявок нет");
            }
        }
    }

    public class GetAll extends BaseAction {

        public GetAll(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            if (tracker.isEmpty()) {
                System.out.println("Текущие заявки:");
                for (Item item : tracker.getAll()) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("В настоящее время заявок нет");
            }
        }
    }

    public class FindByID extends BaseAction {

        public FindByID(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            if (tracker.isEmpty()) {
            System.out.println("Поиск заявки по ID");
            String id = input.ask("Введите ID заявки:");
            if (tracker.findById(id) != null) {
                System.out.println(tracker.findById(id).toString());
            } else {
                System.out.println("Заявки с ID:" + id + " не существует");
            }
            } else {
                System.out.println("В настоящее время заявок нет");
            }
        }
    }

    public class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            if (tracker.isEmpty()) {
                System.out.println("Поиск заявки по названию");
                String name = input.ask("Введите название заявки:");
                if (tracker.findByName(name).size() != 0) {
                    for (Item item : tracker.findByName(name)) {
                        System.out.println(item.toString());
                    }
                } else {
                    System.out.println("Заявок с именем " + name + " не найдено");
                }
            } else {
                System.out.println("В настоящее время заявок нет");
            }
        }
    }

    public class Exit extends BaseAction {

        public Exit(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
        }
    }
}
