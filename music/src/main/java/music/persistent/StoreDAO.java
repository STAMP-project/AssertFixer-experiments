package music.persistent;

import music.model.Entity;

import java.util.List;

public interface StoreDAO<T> {
    boolean add(T t);
    T getById(int id);
    T update(T t);
    boolean delete(int id);
    List<T> findAll();
}
