package projects.gabeross.springrecipemanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.gabeross.springrecipemanager.services.RecipesService;

@Controller
public class RecipeController {

    private final RecipesService recipeService;

    public RecipeController(RecipesService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("recipes")
    public String getRecipePage(Model model) {

        model.addAttribute("recipes", recipeService.getRecipes());

        return "recipes";
    }
}
