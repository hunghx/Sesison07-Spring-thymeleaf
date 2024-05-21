package ra.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.orm.entity.Product;
import ra.orm.service.IProductService;
import ra.orm.validator.ProductNameValidator;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("products",productService.findAll());
        return "product/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        productService.deleteById(id);
        return "redirect:/products/list"; // điều ớng về trang danh sách
    }
//    @PostMapping ("/add")
//    public  String doAdd(@ModelAttribute("product")Product product, BindingResult result){
//        validator.validate(product,result);
//        if(result.hasErrors()){
//            return "employee/add";
//        }
//    }
}
