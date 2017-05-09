/* File: Author.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 */
package transferobjects;

public class Author {
    private Integer authorID;
    private String firstName;
    private String lastName;
    
    public Integer getAuthorID(){
    	return authorID;
    }
    public void setAuthorID(Integer authorID){
    	this.authorID = authorID;
    }
    
    public String getFirstName(){
    	return firstName;
    }
    public void setFirstName(String firstName){
    	this.firstName = firstName;
    }
    
    public String getLastName(){
    	return lastName;
    }
    public void setLastName(String lastName){
    	this.lastName = lastName;
    }
    
}
