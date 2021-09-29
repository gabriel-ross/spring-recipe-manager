package projects.gabeross.springrecipemanager.repositories;

import org.springframework.data.repository.CrudRepository;
import projects.gabeross.springrecipemanager.models.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
