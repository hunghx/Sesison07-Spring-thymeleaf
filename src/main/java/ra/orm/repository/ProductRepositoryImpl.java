package ra.orm.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.orm.entity.Product;

import java.util.Collections;
import java.util.List;
@Repository
public class ProductRepositoryImpl implements IProductRepository{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product ",Product.class).list();
    }

    @Override
    public void save(Product e) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(e);
    }

    @Override
    public Product findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Product.class,id); // id ko c null => neus ko sinh ra exception
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(findById(id));
    }

    @Override
    public void update(Product product) {

    }
}
