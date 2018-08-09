package ru.job4j.generic;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Контейнер пользователей.
 */

public class UserStore<Base> implements Store<User> {

    private SimpleArray<User> users = new SimpleArray();

    @Override
    public void add(User model) {
        users.addModel(model);
    }

    @Override
    public boolean replace(String id, User model) {
        boolean result = false;
        for (int i = 0; i < users.getSize(); i++) {
            if (users.getModel(i).getId() == id) {
                users.setModel(i, model);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < users.getSize(); i++) {
            if (users.getModel(i).getId() == id) {
                users.deleteModel(i);
                result = true;
            }
        }
        return result;
    }

    @Override
    public User findById(String id) {
        User result = null;
        for (int i = 0; i < users.getSize(); i++) {
            if (users.getModel(i).getId() == id) {
                result = users.getModel(i);
            }
         }
        return result;
    }
}
