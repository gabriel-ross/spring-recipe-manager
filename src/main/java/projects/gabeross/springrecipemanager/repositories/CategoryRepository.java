package projects.gabeross.springrecipemanager.repositories;

import org.springframework.data.repository.CrudRepository;
import projects.gabeross.springrecipemanager.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    //
}
