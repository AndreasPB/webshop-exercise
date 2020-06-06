package andreas.webshopexercise.service;

import andreas.webshopexercise.model.Product;
import andreas.webshopexercise.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> readAll() {
        return new ArrayList<>(productRepository.readAll());
    }

    public void create(Product product) {
        productRepository.create(product);
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public Product read(long id) {
        return productRepository.read(id);
    }

    public void delete(long id) {
        productRepository.delete(id);
    }
}
