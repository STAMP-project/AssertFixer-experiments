package ru.job4j.tree.bst;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void whenElementAddThenAdded() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(70);
        tree.add(60);
        tree.add(80);
        System.out.println(tree.iterator().hasNext());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().hasNext());
    }

    @Test
    public void whenLoadTreeThenIteratorGivesCorrectSequence() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(70);
        tree.add(60);
        tree.add(80);
        assertThat(tree.iterator().next(), is(20));
        assertThat(tree.iterator().next(), is(30));
        assertThat(tree.iterator().next(), is(40));
        assertThat(tree.iterator().next(), is(50));
        assertThat(tree.iterator().next(), is(60));
        assertThat(tree.iterator().next(), is(70));
        assertThat(tree.iterator().next(), is(80));
        assertFalse(tree.iterator().hasNext());


    }

    @Test
    public void whenThreeReverseThenReversed() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(70);
        tree.add(60);
        tree.add(80);
        tree.reverse();
        System.out.println(tree.iterator().hasNext());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().next());
        System.out.println(tree.iterator().next());

    }
}
