package ru.job4j.finaltask;

import java.util.*;

/**
 * This class contains Items by Id for sell and buy operations
 *
 * @id keeps information of item's type
 */
public class Bucket implements Comparable<Item> {
    protected LinkedList<Item> toSell = new LinkedList<>();
    protected LinkedList<Item> toBuy = new LinkedList<>();
    private String book = "";

    /**
     * This method validate items by Id
     * to keep one type of items
     *
     * @param item
     * @return true if Id equals to collection's Id or if
     * it's the empty bucket
     */
    private boolean validateBook(Item item) {
        boolean result = false;
        if (toSell.isEmpty() && toBuy.isEmpty()) {
            result = true;
            book = item.getBook();
        } else if (this.book.equals(item.getBook())) {
            result = true;
            book = item.getBook();
        }
        return result;
    }

    public boolean add(Item item) {
        Item itemToAdd;
        itemToAdd = correlate(item);
        boolean result = false;
        if (!validateBook(itemToAdd)) {
            return result;
        }
        if (itemToAdd.isType()) {
            if (itemToAdd.isAction()) {
                result = toSell.add(itemToAdd);
            } else {
                result = toBuy.add(itemToAdd);
            }
        }
        return result;
    }

    public boolean delete(Item item) {
        boolean result = false;
        if (validateBook(item) && !item.isType()) {
            if (item.isAction()) {
                toSell.remove(item); //todo make and attache findById method if ask
                result = true;
            } else {
                toBuy.remove(item);
                result = true;
            }
        }
        return result;
    }


    private Item correlate(Item item) {
        //todo get item volume correct after correlation
        Item result = item;
        Item similarPair = null;
        if (validateBook(item) && item.isType()) {
            if (item.isAction()
                    && !toBuy.isEmpty()
                    && item.isSamePrice(toBuy.peekLast())) { //toBuy
                toBuy.getLast().setVolume(Math.abs(compareVolume(item, toBuy.peekLast())));
                similarPair = toBuy.peekLast();
                if (toBuy.getLast().getVolume() == 0) {
                    toBuy.pollLast();
                }
            } else if (!toSell.isEmpty()
                    && item.isSamePrice(toSell.peekLast())) { // to Sell
                toSell.getLast().setVolume(Math.abs(compareVolume(item, toSell.peekLast())));
                similarPair = toSell.peekLast();
                if (toSell.getLast().getVolume() == 0) {
                    toSell.pollLast();
                }
            }
        }
        //todo divide method here if required
        if (similarPair != null) {
            if (similarPair.getVolume() > item.getVolume()) {
                item = null;
            } else {
                item.setVolume(this.compareVolume(similarPair, item));
            }
        }


        return result;
    }

    /**
     * first, mid column
     */
    private TreeMap<Double, Integer> outputPrice(List<Item> items) {
        TreeMap<Double, Integer> outputList = new TreeMap<>();
        int volumeUpd = 0;
        for (Item item : items) {
            for (Item itemInner : items) {
                if (item.isSamePrice(itemInner)) {
                    volumeUpd += item.getVolume();
                    outputList.put(item.getPrice(), volumeUpd);
                }
            }
            volumeUpd = 0;
        }
        return outputList;
    }

    /**
     * Test output  method to check logic
     */
    public void output() {
        TreeMap<Double, Integer> mapWeBuy = outputPrice(toSell);
        TreeMap<Double, Integer> mapWeSell = outputPrice(toBuy);
        System.out.println("We Buy");
        for (Map.Entry entry : mapWeBuy.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
        System.out.println("We Sell");
        for (Map.Entry entry : mapWeSell.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }

    /**
     * For avoiding ConcurrentModificationException
     * I use one more list
     */
    public void showTable() {
        System.out.println("Buy   Price    Sell");
        TreeMap<Double, Integer> mapWeBuy = outputPrice(toSell);
        TreeMap<Double, Integer> mapWeSell = outputPrice(toBuy);
        String string;
        ArrayList<String> list = new ArrayList();
        ArrayList<Double> equalPriceList = new ArrayList<>();

        for (Map.Entry entry : mapWeBuy.entrySet()) {
            for (Map.Entry entryInner : mapWeSell.entrySet()) {
                if (entry.getKey().equals(entryInner.getKey())) {
                    string = String.format("%1d %9.2f %5d",
                            entry.getValue(), entry.getKey(), entryInner.getValue());
                    list.add(string);
                    equalPriceList.add((Double) entry.getKey());
                    System.out.println(string);
                }
            }
        }
        for (Double key : equalPriceList) {
            mapWeBuy.remove(key);
            mapWeSell.remove(key);
        }

        for (Map.Entry entry : mapWeBuy.entrySet()) {
            System.out.println(
                    String.format("%1d %8.2f", entry.getValue(), entry.getKey())
            );
        }
        for (Map.Entry entry : mapWeSell.entrySet()) {
            System.out.println(
                    String.format("%12.2f %4d", entry.getKey(), entry.getValue())
            );
        }
    }


    /**
     * @param i1 that we have now
     * @param i2 new one
     * @return
     */
    private int compareVolume(Item i1, Item i2) {
        return i1.getVolume() - i2.getVolume();
    }

    @Override
    public int compareTo(Item o) {
        return this.book.compareTo(o.getBook());
    }

}
