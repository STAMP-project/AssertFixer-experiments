package ru.job4j.brackets;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 */
public class Bracket {
    private char bracket;
    private int index;

    Bracket(char bracket, int index) {
        this.bracket = bracket;
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }
    public char getBracket() {
        return this.bracket;
    }
}
