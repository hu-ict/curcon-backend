package nl.hu.curcon.dao.impl;

import nl.hu.curcon.dao.BeoordelingsElementDao;
import nl.hu.curcon.domain.BeoordelingsElement;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

/**
 * @author berend.wilkens, 20 jun. 2017
 */
@Repository
public class BeoordelingsElementDaoImpl extends
		GenericDaoImpl<BeoordelingsElement> implements BeoordelingsElementDao {

	@Override
	public void deleteCascade(int beoordelingsElementId) {
		String hql = "DELETE FROM ToetsElement WHERE beoordelingselement_id = :beoordelingselement_id";
		Query query = this.em.createQuery(hql);
		query.setParameter("beoordelingselement_id", 10);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		super.delete(beoordelingsElementId);
		
	}
}
