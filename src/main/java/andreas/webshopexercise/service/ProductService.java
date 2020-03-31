package andreas.webshopexercise.service;

import andreas.webshopexercise.commands.ProductCommand;
import andreas.webshopexercise.model.Product;

import java.util.Set;

public interface ProductService {
    Set<Product> getProducts();

    Product findById(long l);

    ProductCommand findCommandById(long l);

    ProductCommand saveRecipeCommand(ProductCommand command);

    void deleteById(long idToDelete);
}
