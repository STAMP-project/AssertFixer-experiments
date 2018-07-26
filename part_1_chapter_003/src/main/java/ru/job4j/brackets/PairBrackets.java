package ru.job4j.brackets;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 */

public class PairBrackets {
    private Bracket first;
    private Bracket second;
    private int group;

    PairBrackets(Bracket first, Bracket second, int group) {
        this.first = first;
        this.second = second;
        this.group = group;
    }

    public Bracket getFirst() {
        return first;
    }

    public Bracket getSecond() {
        return second;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
