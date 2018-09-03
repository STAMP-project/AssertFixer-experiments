package ru.job4j.tree.bst;

import java.util.Iterator;
import java.util.LinkedList;

public class BinarySearchTree implements Iterable {

    LinkedList<Node> list = new LinkedList<>();


    class Node {
        int value;
        Node left = null;
        Node right = null;

        Node(int value) {
            this.value = value;
        }
    }

    Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node mirror(Node node) {

        if (node == null) {
            return node;
        }

        /* do the subtrees */
        Node left = mirror(node.left);
        Node right = mirror(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;

    }


    public void reverse() {
        Node result = this.mirror(root);
        root = result;
    }

    @Override
    public Iterator iterator() {
        while (root != null) {
            list.addLast(root);
            root = root.left;
        }

        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                Node node = list.removeLast();
                int result = node.value;
                if (node.right != null) {
                    node = node.right;
                    while (node != null) {
                        list.addLast(node);
                        node = node.left;
                    }
                }
                return result;
            }
        };
    }

}
