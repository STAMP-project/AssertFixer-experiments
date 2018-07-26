package ru.job4j.tracker;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * @version 1
 * @since 14/06/2018
 */
public class StartUI {
    private int[] ranges = new int[]{1, 2, 3, 4, 5, 6, 7};
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillAction();
        do {
            menu.show();
            menu.select(input.ask("Пункт меню:", ranges));
        } while (!"да".equals(this.input.ask("Закончить работу с редактором? да/нет")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}