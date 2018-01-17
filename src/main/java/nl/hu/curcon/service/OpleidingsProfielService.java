package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.domain.Organisatie;
import nl.hu.curcon.dto.CohortDto;
import nl.hu.curcon.dto.LeerlijnDto;
import nl.hu.curcon.dto.OpleidingsProfielDto;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillDto;
import nl.hu.curcon.dto.post.CohortPostDto;
import nl.hu.curcon.dto.post.OpleidingsProfielPostDto;

/**
 * @author berend.wilkens, 1 mei 2017
 */
public interface OpleidingsProfielService {
	int create(Organisatie organisatie, OpleidingsProfielPostDto opleidingsProfielDto);

	void delete(int opleidingsProfielId);

	boolean update(int opleidingsProfielId, OpleidingsProfielPostDto opleidingsProfielDto);

	OpleidingsProfielDto find(int opleidingsProfielId);

	List<OpleidingsProfielDto> findAll();
	// Long count();

	List<CohortDto> findCohortenByOpleidingsProfiel(int opleidingsProfielId);

	int createCohortByOpleidingsProfiel(int opleidingsProfielId, CohortPostDto cohortDto);

	List<BeroepsTaakDto> findBeroepsTakenByOpleidingsProfiel(int opleidingsProfielId);

	List<ProfessionalSkillDto> findProfessionalSkillsByOpleidingsProfiel(int opleidingsProfielId);

	List<LeerlijnDto> findLeerlijnenByOpleidingsProfiel(int opleidingsProfielId);

	boolean addBeroepsTaakToOpleidingsProfiel(int opleidingsProfielId, int id);

	boolean removeBeroepsTaakFromOpleidingsProfiel(int opleidingsProfielId, int beroepstaakId);

	boolean addProfessionalSkillsToOpleidingsProfiel(int opleidingsProfielId, int professionalskillId);

	boolean removeProfessionalSkillsFromOpleidingsProfiel(int opleidingsProfielId, int professionalskillId);
}
