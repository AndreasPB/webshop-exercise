package andreas.webshopexercise.repository;

import andreas.webshopexercise.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}