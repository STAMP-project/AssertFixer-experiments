package ru.job4j.generics;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private int index;
    SimpleArray<T> abstractArray;

    public AbstractStore(int size) {
        this.abstractArray = new SimpleArray<>(size);
    }





    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        if (this.findById(id) != null) {
            this.abstractArray.array[index] = (T) model;
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        if (this.findById(id) != null) {
            abstractArray.array[index] = null;
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (int i = 0; i < abstractArray.array.length; i++) {
            if (id.equals(abstractArray.get(i).getId())) {
                index = i;
                result = (T) abstractArray.get(i);
                break;
            }
        }
        return result;
    }

    public  void add(T model) {
        abstractArray.add(model);
    }
}
