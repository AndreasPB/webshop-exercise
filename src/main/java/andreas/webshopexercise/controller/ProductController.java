package andreas.webshopexercise.controller;

import andreas.webshopexercise.commands.ProductCommand;
import andreas.webshopexercise.model.Product;
import andreas.webshopexercise.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product") ProductCommand command, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });

            // return "/create";
        }

        ProductCommand savedCommand = productService.saveProductCommand(command);

        productService.create(product);
        return "redirect:/";
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productService.read(id));

        return "update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> {
                // log.debug(objectError.toString());
            });

            return "/update";
        }

        productService.update(product);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        productService.delete(id);
        return "redirect:/";
    }
}
