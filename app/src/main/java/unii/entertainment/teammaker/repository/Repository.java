package unii.entertainment.teammaker.repository;

import java.util.List;

public interface Repository<T> {

    void save(T object);

    T load(String id);

    List<T> loadAll();

    void remove(T object);

    void update( T object);
}
