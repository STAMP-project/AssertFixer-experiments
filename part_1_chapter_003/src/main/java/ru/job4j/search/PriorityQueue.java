package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод вставляет задачу в соответствии с её приоритетом.
     * При одинаковом приоритете вставка происходит в конец группы.
     * @param task задача
     */
    public void put(Task task) {
        int temp = tasks.size();
        for (Task value : tasks) {
            if (value.getPriority() > task.getPriority()) {
                temp = tasks.indexOf(value);
                break;
            }
        }
        tasks.add(temp, task);
    }

    public String[] result() {
        String[] result = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            result[i] = tasks.get(i).getDesc();
        }
        return result;
    }
}