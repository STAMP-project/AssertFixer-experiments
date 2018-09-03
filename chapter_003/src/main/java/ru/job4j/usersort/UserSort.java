package ru.job4j.usersort;

import java.util.*;

public class UserSort {

    public Set<User> sort(List<User> list) {
        Set<User> set = new TreeSet<>();
        for (User user : list) {
            set.add(user);
        }
        return set;
    }

    public List<User> sortNameLength(List<User> list) {

        List<User> listOut = new LinkedList<>();
        Comparator<User> lenghComp = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        };
        Set<User> set = new TreeSet<>(lenghComp);
        for (User user : list) {
            set.add(user);
        }
        for (User user : set) {
            listOut.add(user);
        }
        return listOut;
    }

    public List<User> sortByAllFields(List<User> list) {

        class NameComp implements Comparator<User> {
            @Override
            public int compare(User o1, User o2) {
                return o1.compareTo(o2);
            }
        }
        class NameThenAgeComp implements Comparator<User> {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        }
        NameComp nameComp = new NameComp();
        Comparator<User> nameThenAgeComp = nameComp.thenComparing(new NameThenAgeComp());
        Set<User> set = new TreeSet<User>(nameThenAgeComp);
        List<User> listOut = new ArrayList<>();
        for (User user : list) {
            set.add(user);
        }
        for (User user : set) {
            listOut.add(user);
        }
        return listOut;
    }
}
