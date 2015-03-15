package edu.cpp.cs.seniorproject.Recipe.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.cpp.cs.seniorproject.Recipe.data.Recipe;
import edu.cpp.cs.seniorproject.Recipe.data.RecipeMap;
import edu.cpp.cs.seniorproject.Recipe.resource.JSONFS;

/*
 * Implementation of IntRecipePersister
 */

public class RecipePersister implements IntRecipePersister{

	private static final ObjectMapper JSON = new ObjectMapper();
	
	private RecipeMap getRecipeMap(){
		RecipeMap rm = null;
		File recipeFile = JSONFS.getRecipeFile();
		if (recipeFile.exists()){
			try {
				rm = JSON.readValue(recipeFile, RecipeMap.class);
			}catch(IOException e){
				System.out.println("No values found.");
				e.printStackTrace();
			}
		}else {
			rm = new RecipeMap();
		}
		return rm;
	}
	
	private void saveRecipeBank(RecipeMap rm){
		try{
			JSON.writeValue(JSONFS.getRecipeFile(), rm);
		}catch (IOException e){
			System.out.println("Could not write to bank.");
			e.printStackTrace();
		}
	}
	
	public Recipe getRecipe(String ingredientAttr) {
		RecipeMap rm = getRecipeMap();
		//returns whatever value(recipe) is associated with the given key(ingredient)
		return rm.get(ingredientAttr);
	}
	
	
	public void updateRecipe(Recipe r) {
		RecipeMap rm = getRecipeMap();
		rm.put(r.getTitle(), r);
		saveRecipeBank(rm);
	}

	
	public void deleteRecipe(String name) {
		//will remove the association between the ingredient and a recipe
		//may not be needed, since the goal is to build up the database 
		RecipeMap rm = getRecipeMap();
		rm.remove(name);
		saveRecipeBank(rm);
	}

	
	public List<Recipe> listAll() {
		RecipeMap rm = getRecipeMap();
		return new ArrayList<Recipe>(rm.values());
	}

}
