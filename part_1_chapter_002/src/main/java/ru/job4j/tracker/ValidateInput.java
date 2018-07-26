package ru.job4j.tracker;


public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
                try {
                    value = this.input.ask(question, range);
                    invalid = false;
                } catch (MenuOutException moe) {
                    System.out.println("Пожалуйста выберите правильный пункт меню.");
                } catch (NumberFormatException nfe) {
                    System.out.println("Для выбора действий используйте цифры от 1 до 7.");
                }
        } while (invalid);
        return value;
    }
}