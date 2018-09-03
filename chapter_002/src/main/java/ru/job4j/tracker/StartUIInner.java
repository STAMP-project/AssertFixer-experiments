package ru.job4j.tracker;

public class StartUIInner {
    private Input input;

    public StartUIInner(Input input, Tracker tracker) {
        this.input = input;
    }

    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show();
            //int key = Integer.valueOf(input.ask("Select: "));
            menu.select(input.ask("Select: ", menu.getRange()));
        } while (!"y".equals(this.input.ask("Exit?, (y)")));
    }

    public static void main(String[] args) {
        new StartUIInner(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
