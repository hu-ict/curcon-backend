package nl.hu.curcon.dao.impl;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.dao.BeroepsTaakDao;
import nl.hu.curcon.domain.hboi.BeroepsTaak;

/**
 * @author berend.wilkens, 1 jun. 2017
 */
@Repository
public class BeroepsTaakDaoImpl extends GenericDaoImpl<BeroepsTaak> implements BeroepsTaakDao {

	@Override
	public BeroepsTaak find(int activiteitId, int architectuurLaagId, int niveau) {
		String query = "select bt "
				+ "from BeroepsTaak as bt "
				+ "where bt.activiteit.id = " + activiteitId + " "
				+ "and bt.architectuurlaag.id = " + architectuurLaagId + " "
				+ "and bt.niveau = " + niveau;
        return (BeroepsTaak) this.em.createQuery(query).getSingleResult();
	}

}
