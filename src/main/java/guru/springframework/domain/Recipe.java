package guru.springframework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "Recipe")

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // attributes
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String url;
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
    @Lob
    private String directions;
    @Lob
    private Byte[] image;

    // relationships
        // if delete, delete children...
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();


    public Recipe addIngredient(Ingredient ingredient) {

        // add ingredient from this.ingredients
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);

        return this;
    }

    public Recipe removeIngredient(Ingredient ingredient) {

        // remove ingredient from this.ingredients
        // destroy ingredient ???
        this.ingredients.remove(ingredient);

        return this;
    }

    public void setNotes(Notes notes) {

        this.notes = notes;
        notes.setRecipe(this);
    }



}
