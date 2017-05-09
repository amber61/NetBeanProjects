/* Author: Zhe Huang
 */
package businesslayer;

import dataaccesslayer.IngredientsDao;
import dataaccesslayer.IngredientsDaoImpl;
import java.util.List;
import javax.xml.bind.ValidationException;
import transferobjects.Ingredient;

/**
 *
 * @author Jessie
 */
public class IngredientBusinessLogic {
    
    	private IngredientsDao ingredientsDao = null;
	
	public IngredientBusinessLogic(){
		ingredientsDao = new IngredientsDaoImpl();
	}
	
	public List<Ingredient> getAllIngredients(){
		return ingredientsDao.getAllIngredients();
	}
	
	public Ingredient getIngredientById(int ingredient_id){
		return ingredientsDao.getIngredientById(ingredient_id);
	}
	
	public void addIngredient(Ingredient ingredient) throws ValidationException{
		ingredientsDao.addIngredient(ingredient);
	}
	
	public void updateIngredient(Ingredient ingredient) throws ValidationException{
		ingredientsDao.updateIngredient(ingredient);
	}
	
	public void deleteIngredient(Ingredient ingredient){
		ingredientsDao.deleteIngredient(ingredient);
	}
}
