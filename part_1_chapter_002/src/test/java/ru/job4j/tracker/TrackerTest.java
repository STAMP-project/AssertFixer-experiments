package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

public class TrackerTest {
    @Test
    public void addNewItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("description", "lskfjh", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    @Test
    public void replaceName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("description", "lskfjh", 123L);
        tracker.add(previous);
        Item next = new Item("description2", "lskfjh", 123L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("description2"));
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item one = new Item("description", "lskfjh", 123L);
        tracker.add(one);
        Item two = new Item("description", "lskfjh", 123L);
        tracker.add(two);
        Item tree = new Item("description", "lskfjh", 123L);
        tracker.add(tree);
        Item four = new Item("description", "lskfjh", 123L);
        tracker.add(four);
        tracker.delete(one.getId());
        tracker.delete(tree.getId());
        ArrayList<Item> result = new ArrayList<Item>();
        result.add(two);
        result.add(four);
        assertThat(tracker.getAll(), is(result));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item one = new Item("description", "lskfjh", 123L);
        tracker.add(one);
        Item two = new Item("description2", "lfjhh", 178L);
        tracker.add(two);
        ArrayList<Item> res = tracker.findByName(two.getName());
        ArrayList<Item> result = new ArrayList<Item>();
        result.add(two);
        assertThat(res, is(result));
    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item one = new Item("description", "lskfjh", 123L);
        tracker.add(one);
        assertThat(tracker.findById(one.getId()), is(one));
    }

    @Test
    public void getAll() {
        Tracker tracker = new Tracker();
        Item one = new Item("description", "lskfjh", 123L);
        tracker.add(one);
        Item two = new Item("dfghjdfghj", "fgjfg", 1243L);
        tracker.add(two);
        ArrayList<Item> test = new ArrayList<Item>();
        test.add(one);
        test.add(two);
        assertThat(tracker.getAll(), is(test));
    }
}