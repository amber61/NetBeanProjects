/* File: TunasDao.java
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

public interface TunasDao {
	List<Tuna> getAllTunas();
	Tuna getTunaById(Integer tunaId);
	void addTuna(Tuna tuna);
	void updateTuna(Tuna tuna);
	void deleteTuna(Tuna tuna);
}
