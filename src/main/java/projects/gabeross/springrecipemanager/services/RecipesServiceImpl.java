package projects.gabeross.springrecipemanager.services;

import org.springframework.stereotype.Service;
import projects.gabeross.springrecipemanager.models.Recipe;
import projects.gabeross.springrecipemanager.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecipesServiceImpl implements RecipesService {

    private final RecipeRepository recipeRepository;

    public RecipesServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
