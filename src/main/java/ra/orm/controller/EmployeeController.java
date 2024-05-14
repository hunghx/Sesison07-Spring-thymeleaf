package ra.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.orm.entity.Employee;
import ra.orm.service.IEmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("employees",employeeService.findAll());
        return "employee/list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("employee",new Employee());
        return "employee/add";
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/list";
    }
}
