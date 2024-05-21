package ra.orm.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.orm.entity.Employee;
import ra.orm.repository.IEmployeeRepository;
import ra.orm.service.IEmployeeService;

@Component
public class EmployeeValidator implements Validator {
    @Autowired
    private IEmployeeService service;
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        if (service.existByName(employee.getName())){
            errors.rejectValue("name","cbvcvvc","tên da ton tai");
        }
    }
}
