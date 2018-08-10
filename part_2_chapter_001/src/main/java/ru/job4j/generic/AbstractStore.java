package ru.job4j.generic;

public abstract class AbstractStore implements Store<Base> {

    private SimpleArray<Base> container = new SimpleArray();

    @Override
    public void add(Base model) {
        container.addModel(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        for (int i = 0; i < container.getSize(); i++) {
            if (container.getModel(i).getId() == id) {
                container.setModel(i, model);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < container.getSize(); i++) {
            if (container.getModel(i).getId() == id) {
                container.deleteModel(i);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Base findById(String id) {
        Base result = null;
        for (int i = 0; i < container.getSize(); i++) {
            if (container.getModel(i).getId() == id) {
                result = container.getModel(i);
            }
        }
        return result;
    }
}
