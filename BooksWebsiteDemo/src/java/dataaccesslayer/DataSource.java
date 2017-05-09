/* File: SwingMVCDemo.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 * References:
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DataSource {
    
	public DataSource(){}
/*
 * Only use one connection for this application, prevent memory leaks.
 */
	public Connection createConnection(){
            Connection connection = null;
            try{
                Context initCtx = new InitialContext();
                Context envCtx = (Context)initCtx.lookup("java:comp/env");
                javax.sql.DataSource ds = (javax.sql.DataSource)envCtx.lookup("jdbc/booksDatabase");
                connection = ds.getConnection();
            }
            catch(NamingException | SQLException ex){
                ex.printStackTrace();
            }
            return connection;
	}
}