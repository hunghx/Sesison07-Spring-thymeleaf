package ra.orm.service;

import ra.orm.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    void save(Employee e);
}
