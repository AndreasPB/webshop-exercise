package andreas.webshopexercise.repository;

import andreas.webshopexercise.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product> {

    private List<Product> products = new ArrayList<>();

    public ProductRepository() {

        this.products.add(new Product(1, "Kaffe", 45.0, "Kaffe er dejligt"));
        this.products.add(new Product(2, "Te", 30.5, "Te er skønt"));
        this.products.add(new Product(3, "Is", 22.0, "Kølig Magnum"));
        this.products.add(new Product(4, "Lakridspibe", 5.25, "Skippers lakridspibe"));
        this.products.add(new Product(5, "Pepsi Max", 10.5, "Nul kalorier og god smag"));

    }

    public List<Product> readAll() {
        return products;
    }

    public void create(Product product) {
        products.add(product);
    }

    @Override
    public Product read(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
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
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }
}
