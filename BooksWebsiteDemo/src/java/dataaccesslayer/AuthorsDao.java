/* File: AuthorDataAccessObject.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 * References:
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */
package dataaccesslayer;

import java.util.List;

import transferobjects.Author;

public interface AuthorsDao {
	List<Author> getAllAuthors();
	//List<Author> getAuthorsByFirstName(String firstName);
	Author getAuthorByAuthorId(Integer authorID);
	void addAuthor(Author author);
	void updateAuthor(Author author);
	void deleteAuthor(Author author);
}
