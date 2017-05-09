/* Author: Jian Liu
 */
package businesslayer;

import java.util.List;
import dataaccesslayer.RecipesDaoImpl;
import transferobjects.Recipe;
import dataaccesslayer.RecipesDao;

/**
 * Class that delegate to use RecipesDaoImpl.
 * 
 * @author Chunyan Wang, Jian Liu, Qing Zhang, Zhe Huang
 * @version 1.0.0 Date April 11, 2016
 * @since 1.8.0_73
 * 
 * @see java.util.List;
 * @see dataaccesslayer.RecipesDaoImpl;
 * @see transferobjects.Recipe;
 * @see dataaccesslayer.RecipesDao;
 */
public class RecipesBusinessLogic {
    /**
     * A reference to RecipesDao
     */    
    private RecipesDao recipeDao = null;

    /**
     * Default constructor
     */    
    public RecipesBusinessLogic(){
            recipeDao = new RecipesDaoImpl();
    }

    /**
     * To get all recipes in the database
     * @return recipes
     * An arraylist of all recipes
     */   
    public List<Recipe> getAllRecipes(){
            return recipeDao.getAllRecipes();
    }

    /**
     * To get a recipe by corresponding recipeId
     * @return recipe
     * A recipe object
     */    
    public Recipe getRecipeById(Integer recipeId){
            return recipeDao.getRecipeById(recipeId);
    }

    /**
     * To add a recipe
     * @param recipe
     * A recipe object
     */   
    public void addRecipe(Recipe recipe){
            recipeDao.addRecipe(recipe);
    }
    /**
     * To update a recipe
     * @param recipe
     * A recipe object
     */   
    public void updateRecipe(Recipe recipe){
            recipeDao.updateRecipe(recipe);
    }
    /**
     * To delete a recipe
     * @param recipe
     * A recipe object
     */   
    public void deleteRecipe(Recipe recipe){
            recipeDao.deleteRecipe(recipe);
    }
}
