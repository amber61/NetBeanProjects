/* File: AuthorsBusinessLogic.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 */
package businesslayer;

import java.util.List;
import dataaccesslayer.AuthorsDao;
import dataaccesslayer.AuthorsDaoImpl;
import transferobjects.Author;

public class AuthorsBusinessLogic {
	private static final int FIRST_NAME_MAX_LENGTH = 30;
	private static final int LAST_NAME_MAX_LENGTH = 30;
	
	private AuthorsDao authorsDao = null;
	
	public AuthorsBusinessLogic(){
		authorsDao = new AuthorsDaoImpl();
	}
	
	public List<Author> getAllAuthors(){
		return authorsDao.getAllAuthors();
	}
	
	public Author getAuthor(Integer authorID){
		return authorsDao.getAuthorByAuthorId(authorID);
	}
	
	public void addAuthor(Author author) throws ValidationException{
		cleanAuthor(author);
		validateAuthor(author);
		authorsDao.addAuthor(author);
	}
	
	public void updateAuthor(Author author) throws ValidationException{
		cleanAuthor(author);
		validateAuthor(author);
		authorsDao.updateAuthor(author);
	}
	
	public void deleteAuthor(Author author){
		authorsDao.deleteAuthor(author);
	}
	
	private void cleanAuthor(Author author){
		if(author.getFirstName() != null){ 
			author.setFirstName(author.getFirstName().trim());
		}
		if(author.getLastName() != null){ 
			author.setLastName(author.getLastName().trim());
		}
	}
	
	private void validateAuthor(Author author) throws ValidationException{
		validateString(author.getFirstName(), "First Name", FIRST_NAME_MAX_LENGTH, true);
		validateString(author.getLastName(), "Last Name", LAST_NAME_MAX_LENGTH, true);
	}
	
	private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
	    throws ValidationException{
		if(value == null && isNullAllowed){
			// return; // null permitted, nothing to validate
		}
		else if(value == null && ! isNullAllowed){
		    throw new ValidationException(String.format("%s cannot be null", 
		    		fieldName));
		}
		else if(value.length() == 0){
			throw new ValidationException(String.format("%s cannot be empty or only whitespace", 
					fieldName));
		}
		else if(value.length() > maxLength){
			throw new ValidationException(String.format("%s cannot exceed %d characters", 
					fieldName, maxLength));
		}
	}
	/*
	private void validateInt(int value, String fieldName)
	    throws ValidationException{
		if(value <= 0){
			throw new ValidationException(String.format("%s cannot be a negative number", 
					fieldName));
		}
	}
	*/
}
