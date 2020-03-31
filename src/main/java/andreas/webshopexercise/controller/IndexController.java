package andreas.webshopexercise.controller;

import andreas.webshopexercise.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("product", productService.readAll());
        return ("index");
    }
}