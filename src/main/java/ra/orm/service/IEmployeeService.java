package ra.orm.service;

import ra.orm.entity.Employee;

import java.util.List;

public interface IEmployeeService extends IGenericService<Employee,Integer> {
    boolean existByName(String name);
}
