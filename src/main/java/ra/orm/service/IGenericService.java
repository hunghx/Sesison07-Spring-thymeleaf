package ra.orm.service;

import java.util.List;

public interface IGenericService <T,E>{
    List<T> findAll();
    void save(T e);
    T findById(E id);
    void deleteById(E id);
    void update(T t);
}
