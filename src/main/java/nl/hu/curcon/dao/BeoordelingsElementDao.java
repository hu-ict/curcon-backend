package nl.hu.curcon.dao;

import nl.hu.curcon.domain.BeoordelingsElement;
import org.springframework.stereotype.Repository;

/**
 * @author berend.wilkens, 27 apr. 2017
 * BeoordelingsElementDao
 */
@Repository
public interface BeoordelingsElementDao extends GenericDao<BeoordelingsElement> {

	void deleteCascade(int beoordelingsElementId);

}
