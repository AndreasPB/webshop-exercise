package andreas.webshopexercise.service;

import andreas.webshopexercise.model.Product;
import andreas.webshopexercise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> readAll() {
        List<Product> products = new ArrayList<>();
        for(Product product:productRepository.findAll()) {
            products.add(product);
        }
        return products;
    }
    public void create(Product product) {
        productRepository.save(product);
    }
    public void update(Product product) {
        productRepository.save(product);
    }
    public Product read(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        //hvis der ikke findes et product på id, kastes der en fejl
        if (!productOptional.isPresent())
        {
            throw new RuntimeException("Product not found");
        }
        //returner product vha. .get()
        return productOptional.get();
    }
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
