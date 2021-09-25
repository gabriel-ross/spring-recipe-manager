package projects.gabeross.springrecipemanager.repositories;

import org.springframework.data.repository.CrudRepository;
import projects.gabeross.springrecipemanager.models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    //
}
