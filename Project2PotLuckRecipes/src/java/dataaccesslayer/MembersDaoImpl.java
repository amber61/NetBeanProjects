/* Author: Chunyan Wang
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobjects.Member;
import transferobjects.MemberBuilder;

/**
 *
 * @author Jessie
 */
public class MembersDaoImpl implements MembersDao{

private DataSource dataSource;

public MembersDaoImpl(){
    dataSource=new DataSource();
}
    @Override
    public List<Member> getAllMembers() {
        PreparedStatement preparedStatement=null;
        Connection connection=null;
        ResultSet rs=null;
        List<Member> members=null;
      try{
        connection=dataSource.createConnection();
        preparedStatement=connection.prepareStatement("select memberId,isAdmin,alias,"
                + "firstName,lastName,email,userName,password,salt from members");
        rs=preparedStatement.executeQuery();
        members=new ArrayList<>();
        while(rs.next()){
            Member member=MemberBuilder.create()
                    .memberID(rs.getInt("memberId"))
                    .admin(rs.getBoolean("isAdmin"))
                    .alias(rs.getString("alias"))
                    .firstName(rs.getString("firstName"))
                    .lastName(rs.getString("lastName"))
                    .email(rs.getString("email"))
                    .username(rs.getString("userName"))
                    .password(rs.getString("password"))
                    .salt(rs.getString("salt"))
                    .build();
            members.add(member);
        }
      }catch(SQLException ex){
          ex.printStackTrace();
      }
      return members;
    }
    
}
