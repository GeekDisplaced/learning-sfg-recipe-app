package guru.springframework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Table(name = "Category")
@Entity
@RequiredArgsConstructor
@Setter
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // attributes
    private String description;

    // relationships
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
