package guru.springframework.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
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


    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOM unitOM, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.unitOM = unitOM;
        this.recipe = recipe;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
