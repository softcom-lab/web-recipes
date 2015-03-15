package edu.cpp.cs.seniorproject.Recipe.data;

/*
 * This class will define what a recipe is.
 * - ingredients 
 * - title
 * - directions
 */

public class Recipe {
	private String title;
	private String directions;
	private String ingredients;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	
	//maybe make ingredients a list? 
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
}
