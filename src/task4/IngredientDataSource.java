package task4;

import java.util.List;

public interface IngredientDataSource {

    public abstract List<Ingredient> getIngredients(List<Class> ingredientsName);
}
