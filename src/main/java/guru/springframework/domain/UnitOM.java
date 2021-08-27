package guru.springframework.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Table(name = "UnitOM")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class UnitOM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // attribute
    private String description;

}
