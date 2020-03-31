package andreas.webshopexercise.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min=1, max=16)
    private String name;

    @Min(1)
    private double price;

    @NotBlank
    @Size(min=3, max=255)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    private CompanyDescription companyDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Category> categories;


    public Product(long id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

}
