package ra.orm.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.orm.entity.Employee;
import ra.orm.entity.Product;

import java.util.List;


@Repository
public class EmployeeRepositoryImpl implements IEmployeeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee", Employee.class).list();
    }

    @Override
    public void save(Employee e) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(e);
    }
    // crud
    // product
    // id, name, price, stock, createdAt, description, productType (enum ('Nam','Nữ') ), isDeleted
    // 30p : làm 2 tính  năng : hiển thị và xóa
    // 45p :  thêm mới và cập nhật thông tin sản phâm


    // tìm kiếm và phân trang

    @Override
    public Employee findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public boolean existByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return !session.createQuery("from Employee where name =:name", Employee.class)
                .setParameter("name", name).list().isEmpty();
    }
}
