package ru.job4j.finaltask;

import java.util.Objects;

/**
 * @id уникальный ключ заявки.
 * @book идентификатор ценной бумаги.
 * @type add/delete - выставить заявку на торги или снять.
 * true to add, false to delete
 * @action bid/ask - заявка имеет два действия.
 * Заявка на покупка ценной бумаги или на продажу.
 * true for sell
 * @price цена, по которой мы ходим сделать действия покупки или продажи.
 * @volume количество акций, которые мы хотим продать или купить.
 */

public class Item implements Comparable<Item> {
    private int id;
    private String book;
    private boolean type;
    private boolean action;
    private double price;
    private int volume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


    @Override
    public int compareTo(Item o) {
        Double price = this.price;
        return price.compareTo(o.getPrice());
    }

    public boolean isSamePrice(Item o) {
        return Math.abs(this.price - o.price) < 0.001;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id
                && type == item.type
                && action == item.action
                && Double.compare(item.price, price) == 0
                && volume == item.volume
                && Objects.equals(book, item.book);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, book, type, action, price, volume);
    }
}
