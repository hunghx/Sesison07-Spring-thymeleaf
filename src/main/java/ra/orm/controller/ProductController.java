package ra.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.orm.service.IProductService;

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
}
