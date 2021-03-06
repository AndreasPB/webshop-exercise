package andreas.webshopexercise.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double price;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private Company company;
    @OneToOne(cascade = CascadeType.ALL)
    private CompanyDescription companyDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Category> categories;


    public Product() {
    }

    public Product(long id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyDescription getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(CompanyDescription companyDescription) {
        this.companyDescription = companyDescription;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
