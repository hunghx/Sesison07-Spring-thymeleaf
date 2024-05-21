package ra.orm.repository;

import ra.orm.entity.Employee;

import java.util.List;

public interface IEmployeeRepository extends IGenericRepository<Employee,Integer>{
    boolean existByName(String name);
}
