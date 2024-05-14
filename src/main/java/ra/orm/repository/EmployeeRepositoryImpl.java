package ra.orm.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.orm.entity.Employee;

import java.util.Collections;
import java.util.List;


@Repository
public class EmployeeRepositoryImpl implements IEmployeeRepository{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee",Employee.class).list();
    }

    @Override
    public void save(Employee e) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(e);
    }
}
