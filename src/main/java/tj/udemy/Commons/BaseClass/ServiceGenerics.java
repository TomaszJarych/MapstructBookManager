package tj.udemy.Commons.BaseClass;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;


public interface ServiceGenerics  <D, ID extends Serializable>{
	
	D getOneById(ID id);
	
	D save (D dto);
	
	Boolean deleteById(ID id);
	
	List<D> getAllFromDB();

}
