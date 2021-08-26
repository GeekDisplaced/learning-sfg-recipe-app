package guru.springframework.repositories;

import guru.springframework.domain.UnitOM;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOMRepository extends CrudRepository<UnitOM, Long> {

    Optional<UnitOM> findByDescription(String description);
}
