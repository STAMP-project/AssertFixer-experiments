package ru.job4j.bank;

public class Account {
    private double value;
    private int requisites;

    Account(int value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getRequisites() {
        return this.requisites;
    }
}
