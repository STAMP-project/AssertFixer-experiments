package music.persistent;

import music.model.Address;
import music.model.Entity;
import music.model.MusicType;
import music.model.Role;

import java.util.List;

public interface StoreRepository<T> extends StoreDAO {
    List<T> findAllUsers();
    T findByParameter(Address address, Role role, MusicType musicType);
}
