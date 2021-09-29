package projects.gabeross.springrecipemanager.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import projects.gabeross.springrecipemanager.models.*;
import projects.gabeross.springrecipemanager.repositories.CategoryRepository;
import projects.gabeross.springrecipemanager.repositories.RecipeRepository;
import projects.gabeross.springrecipemanager.repositories.UnitOfMeasureRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasurement> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");

        if (!ounceUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM 'ounce' not found");
        }

        UnitOfMeasurement ounceUom = ounceUomOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if (!americanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected category 'American' not found");
        }

        Category american = americanCategoryOptional.get();

        Recipe simpleRecipe = new Recipe();
        simpleRecipe.getCategories().add(american);
        simpleRecipe.setDifficulty(Difficulty.EASY);
        Ingredient simpleIngredient = new Ingredient();
        simpleIngredient.setAmount(new BigDecimal(2));
        simpleIngredient.setUnits(ounceUom);
        simpleIngredient.setRecipe(simpleRecipe);

        simpleRecipe.getIngredients().add(simpleIngredient);

        recipes.add(simpleRecipe);

        return recipes;
    }


}
