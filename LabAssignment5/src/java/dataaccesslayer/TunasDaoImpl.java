/* File: TunasDaoImpl.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Lab Assignment 05 Sample Solution
 * References:
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 *
 * Code in this file was based on materials provided by Stanley Pieda (2015) personal
 * communication.
 */
package dataaccesslayer;

import java.util.List;

import transferobjects.Tuna;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TunasDaoImpl implements TunasDao{

	@Override
	public List<Tuna> getAllTunas() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Tuna> tunas = null;
		try{
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
                            "SELECT TunaId, GenusName, SpeciesName, CommonName, " +
                            "MaxWeight, IUCNstatus FROM Tunas ORDER BY TunaId");
			rs = pstmt.executeQuery();
			tunas = new ArrayList<Tuna>();
			while(rs.next()){
				Tuna tuna = new Tuna();
//				tuna.setTunaId(new Integer(rs.getInt("TunaId")));
				tuna.setGenusName(rs.getString("GenusName"));
				tuna.setSpeciesName(rs.getString("SpeciesName"));
                                tuna.setCommonName(rs.getString("CommonName"));
                                tuna.setMaxWeight(rs.getDouble("MaxWeight"));
                                tuna.setIucnStatus(rs.getString("IUCNstatus"));
				tunas.add(tuna);
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
		return tunas;
	}

	@Override
	public Tuna getTunaById(Integer tunaId) {
        Tuna tuna = null;
        if(tuna == null){
		    throw new UnsupportedOperationException("Not yet implemented");
        }
		return null;
	}

	@Override
	public void addTuna(Tuna tuna) {
            throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void updateTuna(Tuna tuna) {
            throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void deleteTuna(Tuna tuna) {
            throw new UnsupportedOperationException("Not yet implemented");
	}
}
