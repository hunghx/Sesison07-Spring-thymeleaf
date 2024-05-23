package ra.orm.repository;

import ra.orm.entity.Category;

import java.util.List;

public interface ICategoryRepository extends IRepository<Category,Integer>{
    List<Category> findAllByPagination(int offset, int limit);
    long totalElements();
}
