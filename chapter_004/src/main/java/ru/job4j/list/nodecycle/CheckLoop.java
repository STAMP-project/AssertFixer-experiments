package ru.job4j.list.nodecycle;


/**
 * Черепаха и заяц
 */
public class CheckLoop {

    boolean hasCycle(Node first) {
        Node fast, slow;
        if (first == null) { // list does not exist..so no loop either
            return false;
        }
        fast = first;
        slow = first;
        while (true) {
            slow = slow.next;          // 1 hop
            if (fast.next != null) {
                fast = fast.next.next; // 2 hops
            } else {
                return false;          // next node null => no loop
            }
            if (slow == null || fast == null) { // if either hits null..no loop
                return false;
            }
            if (slow == fast) { // if the two ever meet...we must have a loop
                return true;
            }
        }

    }

}
