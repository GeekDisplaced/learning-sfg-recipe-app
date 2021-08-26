package guru.springframework.repositories;

import guru.springframework.domain.UnitOM;
import org.springframework.data.repository.CrudRepository;

public interface UnitOMRepository extends CrudRepository<UnitOM, Long> {
}
