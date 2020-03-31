package andreas.webshopexercise.service;

import andreas.webshopexercise.commands.ProductCommand;
import andreas.webshopexercise.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl {


    public List<Product> readAll() {
        log.debug("Jeg er i servicen");
        List<Product> products = new ArrayList<>();
        for (Product product: productRepository.readAll()) {
            products.add(product);
        }
        return products;
    }

    public void create(Product product) {
        productRepository.create(product);
    }

    public boolean update(Product product) {
        boolean updateOK = productRepository.update(product);
        return updateOK;
    }

    public Product read(long id) {
        return productRepository.read(id);
    }

    public boolean delete(long id) {
        return productRepository.delete(id);
    }

    @Override
    @Transactional
    public ProductCommand saveProductCommand(ProductCommand command) {
        Product detachedProduct = productCommandToProduct.convert(command);

        Product savedProduct = productRepository.save(detachedProduct);
        log.debug("Saved ProductId:" + savedProduct.getId());
        return productToProductCommand.convert(savedProduct);
    }
}
