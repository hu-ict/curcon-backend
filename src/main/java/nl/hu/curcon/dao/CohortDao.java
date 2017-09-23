package nl.hu.curcon.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.domain.Cohort;
import nl.hu.curcon.domain.Leerdoel;

/**
 * @author berend.wilkens, 27 apr. 2017
 * CohortDao
 */
@Repository
public interface CohortDao extends GenericDao<Cohort> {

	List<Leerdoel> findLeerdoelen(int cohortId, int activiteitId, int architectuurlaagId);
}
