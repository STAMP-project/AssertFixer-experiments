package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input input;

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public ValidateInput(final Input input) {
        this.input = input;
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Введите правильный ключ");
                moe.printStackTrace();
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректные данные повторно");
                nfe.printStackTrace();
            }
        } while (invalid);
        return value;
    }

}
