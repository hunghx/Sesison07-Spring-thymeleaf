package ra.orm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping({"/","/index.html"})
    public String index(){
        return "index";
    }
    @GetMapping({"/product","/product.html"})
    public String product(){
        return "product";
    }
    @GetMapping({"/category","/category.html"})
    public String category(){
        return "category";
    }
    @GetMapping({"/user","/user.html"})
    public String user(){
        return "user";
    }
}
