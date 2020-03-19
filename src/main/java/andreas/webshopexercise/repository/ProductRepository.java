package andreas.webshopexercise.repository;

import andreas.webshopexercise.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public ProductRepository() {

        this.products.add(new Product(1, "Kaffe", 88.1, "Kaffe er dejligt"));
        this.products.add(new Product(2, "Te", 34.3, "Te er skønt"));

    }

    public List<Product> readAll() {
        return products;
    }
}
