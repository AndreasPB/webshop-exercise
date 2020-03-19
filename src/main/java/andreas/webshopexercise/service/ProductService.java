package andreas.webshopexercise.service;

import andreas.webshopexercise.model.Product;
import andreas.webshopexercise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> readAll() {
        List<Product> products = new ArrayList<>();
        for (Product product: productRepository.readAll()) {
            products.add(product);
        }
        return products;
    }

    public void create(Product product) {
        productRepository.create(product);
    }
}
