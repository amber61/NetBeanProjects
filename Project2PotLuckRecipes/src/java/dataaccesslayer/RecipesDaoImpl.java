/* Author: Jian Liu
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobjects.Recipe;
import transferobjects.Category;
import transferobjects.Ingredient;
import transferobjects.Tag;
/**
 * Implementation of accessing recipes from database.
 * 
 * @author Chunyan Wang, Jian Liu, Qing Zhang, Zhe Huang
 * @version 1.0.0 Date April 11, 2016
 * @since 1.8.0_73
 * 
 * @see java.sql.Connection;
 * @see java.sql.PreparedStatement;
 * @see java.sql.ResultSet;
 * @see java.sql.SQLException;
 * @see java.util.ArrayList;
 * @see java.util.List;
 * @see transferobjects.Recipe;
 * @see transferobjects.Tag;
 * @see transferobjects.Category;
 * @see transferobjects.Ingredient;
 */
public class RecipesDaoImpl implements RecipesDao{
    

    /**
     * To get all recipes in the database
     * @return recipes
     * An arraylist of all recipes
     */    
    @Override
    public List<Recipe> getAllRecipes(){  
        DataSource ds = new DataSource();
        Connection con = ds.createConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Recipe> recipes = null;
            try{
		pstmt = con.prepareStatement(
                    "SELECT RecipeId, MemberId, Title, Directions, Attribution FROM Recipes ORDER BY RecipeId");
		rs = pstmt.executeQuery();
		recipes = new ArrayList<Recipe>();
		while(rs.next()){
                    Recipe recipe = new Recipe();
                    recipe.setRecipeId(rs.getInt("RecipeId"));
                    recipe.setMemberId(rs.getInt("MemberId"));
                    recipe.setRecipeName(rs.getString("Title"));
		    recipe.setDirection(rs.getString("Directions"));
                    recipe.setAttrubution(rs.getString("Attribution"));
                    // add all tags to recipe
                    List<Tag> tags = getTags(recipe.getRecipeId());
                    for(int i=0; i<tags.size();i++){
                        recipe.addTag(tags.get(i));
                    }
                    // add all categories
                    List<Category> categories = getCategories(recipe.getRecipeId());
                    for(int i=0; i<categories.size();i++){
                        recipe.addCategory(categories.get(i));
                    }
                    // add all ingredients
                    List<Ingredient> ingredients = getIngredients(recipe.getRecipeId());
                    for(int i=0; i<ingredients.size();i++){
                        recipe.addIngredient(ingredients.get(i));
                    }
                    recipes.add(recipe);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
        return recipes;
        
    }
    
    /**
     * To get a recipe by corresponding recipeId
     * @return recipe
     * A recipe object
     */    
    public Recipe getRecipeById(Integer recipeId){
        Recipe recipe = null;
        if(recipe == null){
		    throw new UnsupportedOperationException("Not yet implemented");
        }
	return null;
    }
    
    /**
     * To add a recipe
     * @param recipe
     * A recipe object
     */   
    public void addRecipe(Recipe recipe){
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    /**
     * To update a recipe
     * @param recipe
     * A recipe object
     */   
    public void updateRecipe(Recipe recipe){
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    /**
     * To delete a recipe
     * @param recipe
     * A recipe object
     */   
    public void deleteRecipe(Recipe recipe){
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    /**
    * To get categories by corresponding recipeId
    * @return categories
    * An arraylist of all categories
    */    
    public List<Category> getCategories(int recipeId){
        DataSource ds = new DataSource();
        Connection con = ds.createConnection();
        PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Category> categories = null;
            try{
                pstmt = con.prepareStatement(
                    "SELECT Categories.CategoryId, CategoryText FROM RecipeCategories,Categories " +
                    "WHERE RecipeCategories.CategoryId=Categories.CategoryId AND "
                            + "RecipeCategories.RecipeId = ?");
                pstmt.setInt(1, recipeId);
                rs = pstmt.executeQuery();
		categories = new ArrayList<>();
		while(rs.next()){
                    Category category = new Category();
                    category.setCategoryID(rs.getInt("CategoryId"));
                    category.setCategoryName(rs.getString("CategoryText"));
                    categories.add(category);
		}
            }catch(SQLException e){
		e.printStackTrace();
            }
            finally{
		try{ if(rs != null){ rs.close(); } }
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(pstmt != null){ pstmt.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(con != null){ con.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		}
        return categories;
    }
    
    /**
    * To get tags by corresponding recipeId
    * @return tags
    * An arraylist of tags
    */    
    public List<Tag> getTags(int recipeId){
        DataSource ds = new DataSource();
        Connection con = ds.createConnection();
        PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Tag> tags = null;
            try{
                pstmt = con.prepareStatement(
                    "SELECT Tags.TagId, TagText "
                  + "FROM RecipeTags,Tags "
                  + "WHERE RecipeTags.TagId=Tags.TagId "
                            + "AND RecipeTags.RecipeId = ?");
                pstmt.setInt(1, recipeId);
                rs = pstmt.executeQuery();
		tags = new ArrayList<>();
		while(rs.next()){
                    Tag tag = new Tag();
                    tag.setTagID(rs.getInt("TagId"));
                    tag.setTagText(rs.getString("TagText"));
                    tags.add(tag);
		}
            }catch(SQLException e){
		e.printStackTrace();
            }
            finally{
		try{ if(rs != null){ rs.close(); } }
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(pstmt != null){ pstmt.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(con != null){ con.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		}
        return tags;
    }
    
    /**
    * To get ingredients by corresponding recipeId
    * @return ingredients
    * An arraylist of all ingredients
    */    
    public List<Ingredient> getIngredients(int recipeId){
        DataSource ds = new DataSource();
        Connection con = ds.createConnection();
        PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Ingredient> ingredients = null;
            try{
                pstmt = con.prepareStatement(
                    "SELECT Ingredients.IngredientId, Name, Measurement "
                  + "FROM RecipeIngredients, Ingredients " 
                  + "WHERE RecipeIngredients.IngredientId=Ingredients.IngredientId "
                            + "AND RecipeIngredients.RecipeId = ?");
                pstmt.setInt(1, recipeId);
                rs = pstmt.executeQuery();
		ingredients = new ArrayList<>();
		while(rs.next()){
                    Ingredient ingredient = new Ingredient();
                    ingredient.setIngredient_id(rs.getInt("IngredientId"));
                    ingredient.setName(rs.getString("Name"));
                    ingredient.setMeasurement(rs.getString("Measurement"));
                    ingredients.add(ingredient);
		}
            }catch(SQLException e){
		e.printStackTrace();
            }
            finally{
		try{ if(rs != null){ rs.close(); } }
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(pstmt != null){ pstmt.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(con != null){ con.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		}
        return ingredients;
    }
    
}
