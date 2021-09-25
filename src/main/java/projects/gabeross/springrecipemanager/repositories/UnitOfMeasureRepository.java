package projects.gabeross.springrecipemanager.repositories;

import org.springframework.data.repository.CrudRepository;
import projects.gabeross.springrecipemanager.models.UnitOfMeasurement;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasurement, Long> {
    //
}
