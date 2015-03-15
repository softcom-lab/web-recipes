package edu.cpp.cs.seniorproject.Recipe.resource;

import java.io.File;

/*
 * Outlines the file system/directory for JSON to store/retrieve recipes.
 * ****Maybe replaced with a database later. 
 */

public class JSONFS {

	/*
	 * makes the base directory of the file system that will be used to store recipes
	 */
	private static final String BASE_DIR = System.getProperty("recipe.home") + "/cs461";
	
	/*
	 * Returns the file that's going to be storing the JSON version of the recipe object.
	 */
	
	public static File getRecipeFile(){
		File f = new File(BASE_DIR + "/" + "recipe-bank.json");
		if(!f.getParentFile().exists()){
			f.getParentFile().mkdirs();
		}
		return f;
	}
}
