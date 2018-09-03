package ru.job4j.finaltask;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BucketTest {
    @Test
    public void whenAddToDifferentItemsThenAdded() {
        Item itemToSell = new Item();
        itemToSell.setType(true);
        itemToSell.setAction(true);
        itemToSell.setPrice(10D);
        itemToSell.setVolume(11);
        itemToSell.setBook("1111");

        Item itemToBuy = new Item();
        itemToBuy.setType(true);
        itemToBuy.setAction(false);
        itemToBuy.setPrice(20D);
        itemToBuy.setVolume(22);
        itemToBuy.setBook("1111");

        Bucket bucket = new Bucket();
        bucket.add(itemToSell);
        bucket.add(itemToBuy);
        boolean result = bucket.toBuy != null && bucket.toSell != null;
        assertThat(result, is(true));
    }

    @Test
    public void whenAddItemsThenTheyAutoSold() {
        Item itemToSell = new Item();
        itemToSell.setId(111);
        itemToSell.setType(true);
        itemToSell.setAction(true);
        itemToSell.setPrice(10D);
        itemToSell.setVolume(22);
        itemToSell.setBook("1111");

        Item itemToBuy = new Item();
        itemToBuy.setId(11);
        itemToBuy.setType(true);
        itemToBuy.setAction(false);
        itemToBuy.setPrice(10D);
        itemToBuy.setVolume(22);
        itemToBuy.setBook("1111");

        Bucket bucket = new Bucket();
        bucket.add(itemToSell);
        bucket.add(itemToBuy);
        boolean result = bucket.toSell.isEmpty();
        assertThat(result, is(true));
    }

    @Test
    public void whenAddItemsThenTheyAutoSoldToSellIsNotEmpty() {
        Item itemToSell = new Item();
        itemToSell.setId(111);
        itemToSell.setType(true);
        itemToSell.setAction(true);
        itemToSell.setPrice(10D);
        itemToSell.setVolume(220);
        itemToSell.setBook("1111");

        Item itemToBuy = new Item();
        itemToBuy.setId(11);
        itemToBuy.setType(true);
        itemToBuy.setAction(false);
        itemToBuy.setPrice(10D);
        itemToBuy.setVolume(22);
        itemToBuy.setBook("1111");
        int expected = itemToSell.getVolume() - itemToBuy.getVolume();
        Bucket bucket = new Bucket();
        bucket.add(itemToSell);
        bucket.add(itemToBuy);
        int result = bucket.toSell.iterator().next().getVolume();
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddItemsThenTheyAutoSoldToBuyIsNotEmpty() {
        Item itemToSell = new Item();
        itemToSell.setId(111);
        itemToSell.setType(true);
        itemToSell.setAction(true);
        itemToSell.setPrice(10D);
        itemToSell.setVolume(22);
        itemToSell.setBook("1111");

        Item itemToBuy = new Item();
        itemToBuy.setId(11);
        itemToBuy.setType(true);
        itemToBuy.setAction(false);
        itemToBuy.setPrice(10D);
        itemToBuy.setVolume(220);
        itemToBuy.setBook("1111");

        int expected = itemToBuy.getVolume() - itemToSell.getVolume();

        Bucket bucket = new Bucket();
        bucket.add(itemToSell);
        bucket.add(itemToBuy);
        int result = bucket.toSell.iterator().next().getVolume();
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddItemsThenShowTable() {
        Item itemToSell = new Item();
        itemToSell.setId(111);
        itemToSell.setType(true);
        itemToSell.setAction(true);
        itemToSell.setPrice(10D);
        itemToSell.setVolume(21);
        itemToSell.setBook("1111");

        Item anotherItemToSell = new Item();
        anotherItemToSell.setId(112);
        anotherItemToSell.setType(true);
        anotherItemToSell.setAction(true);
        anotherItemToSell.setPrice(10D);
        anotherItemToSell.setVolume(22);
        anotherItemToSell.setBook("1111");

        Item itemToSell1 = new Item();
        itemToSell1.setId(111);
        itemToSell1.setType(true);
        itemToSell1.setAction(true);
        itemToSell1.setPrice(13D);
        itemToSell1.setVolume(21);
        itemToSell1.setBook("1111");

        Item itemToBuy1 = new Item();
        itemToBuy1.setId(113);
        itemToBuy1.setType(true);
        itemToBuy1.setAction(false);
        itemToBuy1.setPrice(13D);
        itemToBuy1.setVolume(23);
        itemToBuy1.setBook("1111");

        Item itemToBuy = new Item();
        itemToBuy.setId(113);
        itemToBuy.setType(true);
        itemToBuy.setAction(false);
        itemToBuy.setPrice(120D);
        itemToBuy.setVolume(23);
        itemToBuy.setBook("1111");

        Bucket bucket = new Bucket();

        bucket.add(anotherItemToSell);
        bucket.add(itemToSell);
        bucket.add(itemToBuy);
        bucket.add(itemToSell1);
        bucket.add(itemToBuy1);
        bucket.output();
        bucket.showTable();
    }



}