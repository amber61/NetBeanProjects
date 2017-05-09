/* File: TunasBusinessLogic.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Lab Assignment 05 Sample Solution
 * 
 * Code in this file was based on materials provided by Stanley Pieda (2015) personal
 * communication.
 */
package businesslayer;

import java.util.List;
import dataaccesslayer.TunasDaoImpl;
import transferobjects.Tuna;
import dataaccesslayer.TunasDao;

public class TunasBusinessLogic {
	
	private TunasDao tunasDao = null;
	
	public TunasBusinessLogic(){
		tunasDao = new TunasDaoImpl();
	}
	
	public List<Tuna> getAllTunas(){
		return tunasDao.getAllTunas();
	}
	
	public Tuna getTuna(Integer tunaId){
		return tunasDao.getTunaById(tunaId);
	}
	
	public void addTuna(Tuna tuna) throws ValidationException{
		tunasDao.addTuna(tuna);
	}
	
	public void updateTuna(Tuna tuna) throws ValidationException{
		tunasDao.updateTuna(tuna);
	}
	
	public void deleteTuna(Tuna tuna){
		tunasDao.deleteTuna(tuna);
	}
}
