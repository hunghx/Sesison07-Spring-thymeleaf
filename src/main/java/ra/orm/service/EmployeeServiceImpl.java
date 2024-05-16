package ra.orm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.orm.entity.Employee;
import ra.orm.repository.IEmployeeRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee e) {
        e.setIsDelete(false);
        employeeRepository.save(e);
    }

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
}
