package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.*;


@ThreadSafe
public class UserStorage {
    //  made this storage protected only for tests
    @GuardedBy("this")
    final protected ConcurrentMap<Integer, User> storage = new ConcurrentHashMap<>();

    public synchronized boolean add(User user) {
        boolean result = false;
        if (!storage.containsKey(user.getId())) {
            storage.put(user.getId(), user);
            result = true;
        }
        return result;
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        if (storage.containsKey(user.getId())) {
            storage.put(user.getId(), user);
            result = true;
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        boolean result = false;
        //noinspection FieldAccessNotGuarded,FieldAccessNotGuarded,FieldAccessNotGuarded
        if (storage.containsKey(user.getId())) {
            storage.remove(user.getId());
            result = true;
        }
        return result;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        //According the task there's on information how i must catch nulls
        User userFrom = storage.get(fromId);
        User userTo = storage.get(toId);
        if (storage.get(fromId).getAmount() >= amount) {
            userFrom.setAmount(userFrom.getAmount() - amount);
            userTo.setAmount(userTo.getAmount() + amount);
            storage.put(storage.get(fromId).getId(), userFrom);
            storage.put(storage.get(toId).getId(), userTo);
            result = true;
        }
        return result;
    }
}
