package guru.springframework.domain;



import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "Ingredients")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // attributes
    private String description;
    private BigDecimal amount;

    // relationships
    @ManyToOne
    private Recipe recipe;
    @OneToOne
    private UnitOM unitOM;

    public Ingredient(String description, BigDecimal amount, UnitOM unitOM, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.unitOM = unitOM;
        this.recipe = recipe;
    }


}
