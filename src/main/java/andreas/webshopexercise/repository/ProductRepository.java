package andreas.webshopexercise.repository;

import andreas.webshopexercise.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product> {

    private List<Product> products = new ArrayList<>();

    public ProductRepository() {

        this.products.add(new Product(1, "Kaffe", 88.1, "Kaffe er dejligt"));
        this.products.add(new Product(2, "Te", 34.3, "Te er skønt"));

    }

    public List<Product> readAll() {
        return products;
    }

    public void create(Product product) {
        products.add(product);
    }

    @Override
    public Product read(long id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean update(Product product) {
        for(int i=0; i<products.size(); i++) {
            if(products.get(i).getId() == product.getId()) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
