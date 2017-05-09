/* Author: Qing Zhang
 */
package dataaccesslayer;

import java.util.List;
import transferobjects.Tag;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TagsDaoImpl implements TagsDao{

	@Override
	public List<Tag> getAllTags() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Tag> tags = null;
		try{
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
                            "SELECT TagId,  TagText FROM Tags");
			rs = pstmt.executeQuery();
			tags = new ArrayList<Tag>();
			while(rs.next()){
				Tag tag = new Tag();
				tag.setTagID(new Integer(rs.getInt("TagId")));
				tag.setTagText(rs.getString("TagText"));
				
				tags.add(tag);
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
		return tags;
	}

	/**@Override
	public Tag getTagById(Integer tagId) {
        Tag tag = null;
        if(tag == null){
		    throw new UnsupportedOperationException("Not yet implemented");
        }
		return null;
	}

	@Override
	public void addTag(Tag tag) {
            throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void updateTag(Tag tag) {
            throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void deleteTag(Tag tag) {
            throw new UnsupportedOperationException("Not yet implemented");
	}*/
}

