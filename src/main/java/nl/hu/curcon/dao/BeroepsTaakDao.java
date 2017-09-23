package nl.hu.curcon.dao;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.domain.BeroepsTaak;

/**
 * @author berend.wilkens, 27 apr. 2017
 * BeroepsTaakDao
 */
@Repository
public interface BeroepsTaakDao extends GenericDao<BeroepsTaak> {
	BeroepsTaak find(int activiteitId, int architectuurLaagId, int niveau);

}
