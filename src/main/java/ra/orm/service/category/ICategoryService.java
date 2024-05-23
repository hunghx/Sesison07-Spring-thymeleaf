package ra.orm.service.category;

import ra.orm.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    List<Category> findAllByPagination(Integer page, Integer size,String keyword);
    Category findById(Integer id);
    void save(Category t);
    void deleteById(Integer id);
    long totalElements(String keyword);
}
