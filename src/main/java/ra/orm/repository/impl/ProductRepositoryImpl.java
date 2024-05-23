package ra.orm.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.orm.entity.Category;
import ra.orm.entity.Product;
import ra.orm.repository.IProductRepository;

import java.util.Collections;
import java.util.List;
@Repository
public class ProductRepositoryImpl implements IProductRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product where isDeleted = false", Product.class).list();
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public void save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        if (product.getId()==null){
            // thêm mới
            session.saveOrUpdate(product);
        }else {
            // cập nhật
        }
    }

    @Override
    public void deleteById(Integer id) {

    }
}
