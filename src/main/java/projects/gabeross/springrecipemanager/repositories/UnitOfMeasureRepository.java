package projects.gabeross.springrecipemanager.repositories;

import org.springframework.data.repository.CrudRepository;
import projects.gabeross.springrecipemanager.models.UnitOfMeasurement;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasurement, Long> {
    Optional<UnitOfMeasurement> findByDescription(String description);
}
