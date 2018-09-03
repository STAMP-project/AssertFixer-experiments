package ru.job4j.usersort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sorter {

    public Sorter() { //Нужно прогнать через код форматтер перед валидацией, чтобы поправить отступы сразу везде. Конструктор по умолчанию можно не объявлять
        //если нет других.

    }

    Set<User> sort(List<User> list) {
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList; //Семантически может запутать потому, что сет назван листом
    }

    List<User> sortnamelength(List<User> list) { //КэмэлКейс неправильный тут и далее во всех методах
        Comparator<User> compar = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        list.sort(compar);
        return list;
    }

    List<User> sortboth(List<User> list) {
        Comparator<User> compar1 = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}