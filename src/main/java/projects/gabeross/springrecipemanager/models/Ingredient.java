package projects.gabeross.springrecipemanager.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private BigDecimal amount;

    // default for 1:1 is eager fetch type
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasurement units;

    // no cascade so deleting an ingredient doesn't cascade to deleting the related recipe
    // cascade default is none
    @ManyToOne
    private Recipe recipe;

    public Ingredient() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasurement getUnits() {
        return units;
    }

    public void setUnits(UnitOfMeasurement units) {
        this.units = units;
    }
}
