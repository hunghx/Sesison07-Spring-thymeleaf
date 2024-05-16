package ra.orm.repository;

import ra.orm.entity.Employee;

import java.util.List;

public interface IGenericRepository<T,E> {
    List<T> findAll();
    void save(T e);
    T findById(E id);
    void deleteById(E id);
    void update(T t);
}
