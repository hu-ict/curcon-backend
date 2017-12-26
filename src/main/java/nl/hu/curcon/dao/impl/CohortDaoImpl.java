package nl.hu.curcon.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.dao.CohortDao;
import nl.hu.curcon.domain.Cohort;
import nl.hu.curcon.domain.Leerdoel;

/**
 * @author berend.wilkens, 2 jun. 2017
 */
@Repository
public class CohortDaoImpl extends GenericDaoImpl<Cohort> implements CohortDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Leerdoel> findLeerdoelen(int cohortId, int activiteitId, int architectuurlaagId) {
		String query = "select leerdoel "
				+ "from Cohort as cohort "
				+ "inner join cohort.cursussen as cursus "
				+ "inner join cursus.leerdoelen as leerdoel "
				+ "where cohort.id = " + cohortId + " "
				+ "order by cursus.periode";
//				+ "and co.cursussen.leerdoelen.beroepstaak.activiteit.id = " + activiteitId + " "
//				+ "and co.cursussen.leerdoelen.beroepstaak.architectuurlaag.id = " + architectuurlaagId;
		List<Leerdoel> leerdoelen = this.em.createQuery(query).getResultList();
//		List<Object[]> listResult = ;
//		for (Object[] aRow : listResult) {
//			Leerdoel leerdoel = (Leerdoel) aRow[0];
//			leerdoelen.add(leerdoel);
//			int periode = (int) aRow[1];
//		    leerdoel.setOmschrijving(periode+ " "+leerdoel.getOmschrijving());
//		    
//		} 
		return leerdoelen; 
	}
}
