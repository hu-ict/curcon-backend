package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.domain.OpleidingsProfiel;
import nl.hu.curcon.dto.CohortDto;
import nl.hu.curcon.dto.CursusDto;
import nl.hu.curcon.dto.post.CohortPostDto;

/**
 * @author berend.wilkens, 3 mei 2017
 */
public interface CohortService {
	int create(OpleidingsProfiel opleidingsProfiel, CohortPostDto cohortDto);

	void delete(int cohortId);

	boolean update(int cohortId, CohortPostDto cohortDto);

	CohortDto find(int cohortId);

	List<CohortDto> findAll();

	List<CursusDto> getCursussenByCohort(int cohortId);

	boolean removeCursusFromCohort(int cohortId, int cursusId);

	boolean addCursusToCohort(int cohortId, int cursusId);
}