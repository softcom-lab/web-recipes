package edu.cpp.cs.seniorproject.Recipe.manager;

import java.util.List;

import edu.cpp.cs.seniorproject.Recipe.data.Recipe;

/*
 * Interface for the general methods used to modify a recipe.
 */

public interface IntRecipePersister {

	public Recipe getRecipe(String ingredientAttr);
	public void updateRecipe(Recipe r);
	public void deleteRecipe(String name);
	public List<Recipe> listAll();
}
