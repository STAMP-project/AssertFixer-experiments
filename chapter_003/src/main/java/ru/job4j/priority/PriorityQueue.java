package ru.job4j.priority;

import java.util.Comparator;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    Comparator<Task> comparator = new Comparator<Task>() {
        @Override
        public int compare(Task o1, Task o2) {
            return Integer.compare(o1.getPriority(), o2.getPriority());
        }
    };
    public void put(Task task) {
        tasks.add(task);
        tasks.sort(comparator);
    }

    public Task take() {
        return this.tasks.poll();
    }
}