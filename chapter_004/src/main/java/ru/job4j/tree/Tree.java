package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    Node<E> root;

    public Tree(E i) {
    }

    public Tree() {

    }


    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public boolean add(E i, E i1) {
        boolean result = false;
        if (root == null) {
            root = new Node<>(i);
            root.add(new Node(i1));
        } else {
            Optional<Node<E>> optional;
            optional = findBy(i);
            Node<E> node = optional.get();
            node.add(new Node(i1));
        }

        return result;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            Node<E> node = root;
            List<Node<E>> children = new ArrayList<>();

            @Override
            public boolean hasNext() {
                boolean result = false;
                return node.leaves() != null;
            }

            @Override
            public E next() {

                return null;
            }
        };
        return iterator;
    }

    public boolean isBinary() {
        boolean result = false;


        return result;
    }
}
