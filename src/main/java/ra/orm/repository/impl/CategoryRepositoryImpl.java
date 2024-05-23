package ra.orm.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.orm.entity.Category;
import ra.orm.repository.ICategoryRepository;

import java.util.Collections;
import java.util.List;
@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category where isDeleted = false", Category.class).list();
    }

    @Override
    public List<Category> findAllByPagination(int offset, int limit) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category where isDeleted = false", Category.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .list();
    }

    @Override
    public long totalElements() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Category where isDeleted = false ",Long.class).getSingleResult();
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
