package edu.cpp.cs.seniorproject.Recipe.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.cpp.cs.seniorproject.Recipe.data.Recipe;
import edu.cpp.cs.seniorproject.Recipe.manager.IntRecipePersister;

/*
 * Current Status: 
 * - Fix JS actions
 */

@RestController
public class Controller {

	@Autowired
	private IntRecipePersister persister;

	/*
	 * checks to make sure that the web service connection has been established
	 */
	@RequestMapping(value = "/cs461/ping", method = RequestMethod.GET)
	String alive() {
		return "I AM ALIVE. WHAT ABOUT YOU?";
	}
	
	@RequestMapping(value = "/cs461/recipe/{name}", method = RequestMethod.GET)
	Recipe getRecipe(@PathVariable("name") String ingredientName){
		Recipe r = persister.getRecipe(ingredientName);
		return r;
	}
	
	@RequestMapping(value = "/cs461/recipe/{name}", method = RequestMethod.POST)
	Recipe updateRecipe(
			@PathVariable("name") String title,
			@RequestParam("instrc") String directions,
			@RequestParam(value = "ingr", required = true) String instruct){
		Recipe recipe = new Recipe();
		recipe.setTitle(title);
		recipe.setDirections(directions);
		recipe.setIngredients(instruct);
		persister.updateRecipe(recipe);
		return recipe;
	}
	
	@RequestMapping(value = "/cs461/recipes/list", method = RequestMethod.GET)
	List<Recipe> recipeList(){
		return persister.listAll();
	}
	
	@RequestMapping(value = "/cs461/recipes", method = RequestMethod.GET)
	ModelAndView getRecipeHomepage(){
		ModelAndView mav = new ModelAndView("recipes");
		mav.addObject("recipes", persister.listAll());
		return mav;
	}
}
