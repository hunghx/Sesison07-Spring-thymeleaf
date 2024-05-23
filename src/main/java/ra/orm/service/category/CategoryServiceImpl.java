package ra.orm.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.orm.entity.Category;
import ra.orm.repository.ICategoryRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAllByPagination(Integer page, Integer size,String keyword) {
        // 0 - 0
        // 1 // 4
        // 2 // 8
        int offset = page*size;
        return categoryRepository.findAllByPagination(offset,size,keyword);
    }

    @Override
    public long totalElements(String keyword) {
        return categoryRepository.totalElements(keyword);
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public void save(Category t) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
