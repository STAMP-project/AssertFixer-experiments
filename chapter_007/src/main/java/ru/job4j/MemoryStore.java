package ru.job4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryStore implements Store {
    private static AtomicInteger userId = new AtomicInteger(0);
    private List<User> users = new CopyOnWriteArrayList<>();
    private static MemoryStore ourInstance = new MemoryStore();

    public static MemoryStore getInstance() {
        return ourInstance;
    }

    private MemoryStore() {
        User user = new User("Test", "Test", "Test", "Test@Test.com");
        user.setId(generateId());
        users.add(user);
    }

    @Override
    public void addUser(User user) {
        user.setId(generateId());
        users.add(user);
    }

    @Override
    public void updateUser(int id, User updUser) {
        User oldUser = findById(id);
        oldUser.setLogin(updUser.getLogin());
        oldUser.setPassword(updUser.getPassword());
        oldUser.setName(updUser.getName());
        oldUser.setEmail(updUser.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        users.remove(this.findById(id));
    }

    @Override
    public User findById(int id) {
        User result = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().get() == id) {
                result = users.get(i);
                break;
            }
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    public AtomicInteger generateId() {
        return new AtomicInteger(userId.incrementAndGet());
    }
}
