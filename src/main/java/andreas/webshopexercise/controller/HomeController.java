package andreas.webshopexercise.controller;

import andreas.webshopexercise.model.Product;
import andreas.webshopexercise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("product", productService.readAll());
        return ("index");
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product) {
        productService.create(product);

        return "redirect:/";
    }
}