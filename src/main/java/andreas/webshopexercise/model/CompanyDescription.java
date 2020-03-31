package andreas.webshopexercise.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class CompanyDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @OneToOne
    private Product product;

}
