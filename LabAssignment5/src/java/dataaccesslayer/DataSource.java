/* File: DataSource.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Lab Assignment 05 Sample Solution
 * References:
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 *
 * Code in this file was based on materials provided by Stanley Pieda (2015) personal
 * communication updated by Zhe Huang.
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DataSource {
	
	public DataSource(){}

	public Connection createConnection(){
		Connection connection = null;
            try{
                Context initCtx = new InitialContext();
                Context envCtx = (Context)initCtx.lookup("java:comp/env");
                javax.sql.DataSource ds = (javax.sql.DataSource)envCtx.lookup("jdbc/tunafishesDatabase");
                connection = ds.getConnection();
            }
            catch(NamingException | SQLException ex){
                ex.printStackTrace();
            }
            return connection;

	}
}