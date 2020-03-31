package andreas.webshopexercise.commands;

import andreas.webshopexercise.model.Category;
import andreas.webshopexercise.model.Company;
import andreas.webshopexercise.model.CompanyDescription;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class ProductCommand {

    private long id;

    @NotBlank
    @Size(min=1, max=16)
    private String name;

    @Min(1)
    private double price;

    @NotBlank
    @Size(min=3, max=255)
    private String description;

    private Company company;
    private CompanyDescription companyDescription;
    private Set<Category> categories;

}
