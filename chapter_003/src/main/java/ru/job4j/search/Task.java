package ru.job4j.search;
/**Task.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
class Task {
    private String desc;
    private int priority;

    Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    String getDesc() {
        return desc;
    }

    int getPriority() {
        return priority;
    }
}