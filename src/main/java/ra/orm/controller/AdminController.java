package ra.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.orm.dto.request.CreateProductForm;
import ra.orm.service.category.ICategoryService;
import ra.orm.service.product.IProductService;

@Controller
public class AdminController {

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;
    @GetMapping({"/","/index.html"})
    public String index(){
        return "index";
    }
    @GetMapping({"/product","/product.html"})
    public String product(Model model){
        model.addAttribute("add_product",new CreateProductForm());
        model.addAttribute("products",productService.findAll());
        model.addAttribute("categories",categoryService.findAll());
        return "product";
    }

    // thêm mơi
    @PostMapping("/product/add")
    public  String doAddProduct(@ModelAttribute("add_product") CreateProductForm request){
        productService.save(request);
        return "redirect:/product";
    }

    @GetMapping({"/category","/category.html"})
    public String category( @RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "size" , defaultValue = "4") Integer size,
                            @RequestParam(defaultValue = "") String keyword ,
                            Model model){
        // *** phan trang cần gửi gì ?
        // số trang
        // số phần tu trong 1 trang
        // *** cần phải  trả ve
        // list các phần tử cua trang đó
        // số trang hien tại
        // số ptu tren trang
        // tổng số trang
        long totalElements = categoryService.totalElements(keyword);
        long a = totalElements/size; // phần nguyên
        long b = totalElements%size; // phần dư
        long total = b==0 ? a : a+1;
        model.addAttribute("total", total);
        model.addAttribute("categories",categoryService.findAllByPagination(page,size,keyword));
        model.addAttribute("page",page);
        model.addAttribute("size",size);
        model.addAttribute("keyword",keyword);
        return "category";
    }

    @GetMapping({"/user","/user.html"})
    public String user(){
        return "user";
    }
}
