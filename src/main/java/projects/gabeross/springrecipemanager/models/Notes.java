package projects.gabeross.springrecipemanager.models;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // No cascade operations as we don't want deleting a notes object to delete the associated recipe
    @OneToOne
    private Recipe recipe;

    // this tells JPA to store the string in a SQL Clob type field (character large object), as strings
    // are typically limited to 256 characters otherwise and we want notes longer than that.
    @Lob
    private String recipeNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
