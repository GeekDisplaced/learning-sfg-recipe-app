package guru.springframework.domain;



import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Table(name = "Notes")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // attributes
    @Lob
    private String notes;

    // relationships
    @OneToOne
    private Recipe recipe;

}
