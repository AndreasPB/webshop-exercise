package andreas.webshopexercise.repository;

import java.util.List;

public interface ICrudRepository<T> {
    List<T> readAll();
    void create(T t);
    T read(long id);
    boolean update(T t);
    boolean delete(long id);
}
