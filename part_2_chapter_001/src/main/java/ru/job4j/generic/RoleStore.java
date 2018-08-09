package ru.job4j.generic;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Контейнер ролей.
 */

public class RoleStore<Base> implements Store<Role> {

    private SimpleArray<Role> roles = new SimpleArray();

    @Override
    public void add(Role model) {
        roles.addModel(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        boolean result = false;
        for (int i = 0; i < roles.getSize(); i++) {
            if (roles.getModel(i).getId() == id) {
                roles.setModel(i, model);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < roles.getSize(); i++) {
            if (roles.getModel(i).getId() == id) {
                roles.deleteModel(i);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Role findById(String id) {
        Role result = null;
        for (int i = 0; i < roles.getSize(); i++) {
            if (roles.getModel(i).getId() == id) {
                result = roles.getModel(i);
            }
        }
        return result;
    }
}


