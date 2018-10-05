package ru.job4j.search;

import java.util.LinkedList;
/**PriorityQueue.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    void put(Task task) {
        if (tasks.isEmpty()) {
            tasks.add(0, task);
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                if (task.getPriority() <= tasks.get(i).getPriority()) {
                tasks.add(i, task);
                break;
                } else if (task.getPriority() > tasks.get(tasks.size() - 1).getPriority()) {
                    tasks.add(tasks.size(), task);
                    break;
                }
            }
        }
    }

    Task take() {
        return this.tasks.poll();
    }
}