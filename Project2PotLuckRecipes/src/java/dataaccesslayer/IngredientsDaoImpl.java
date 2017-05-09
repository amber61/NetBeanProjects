/* Author: Zhe Huang
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobjects.Ingredient;

/**
 *
 * @author Jessie
 */
public class IngredientsDaoImpl implements IngredientsDao{
    
    	@Override
	public List<Ingredient> getAllIngredients() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Ingredient> ingredients = null;
		try{
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
                            "SELECT IngredientId, Name, Measurement FROM ingredients ORDER BY IngredientId");
			rs = pstmt.executeQuery();
			ingredients = new ArrayList<>();
			while(rs.next()){
				Ingredient ingre = new Ingredient();
				ingre.setIngredient_id(rs.getInt("IngredientId"));
				ingre.setName(rs.getString("Name"));
				ingre.setMeasurement(rs.getString("Measurement"));
				ingredients.add(ingre);
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
		return ingredients;
	}

	@Override
	public Ingredient getIngredientById(int ingredient_id) {
        Ingredient ingredient = null;
        if(ingredient == null){
		    throw new UnsupportedOperationException("Not yet implemented");
        }
		return null;
	}

	@Override
	public void addIngredient(Ingredient ingredient) {
            throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void updateIngredient(Ingredient ingredient) {
            throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void deleteIngredient(Ingredient ingredient) {
            throw new UnsupportedOperationException("Not yet implemented");
	}
}
