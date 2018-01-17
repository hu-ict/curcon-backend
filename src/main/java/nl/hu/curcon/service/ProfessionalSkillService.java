package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.competence.ProfessionalSkillDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillTypesDto;

/**
 * @author berend.wilkens, 19 jun. 2017
 */
public interface ProfessionalSkillService {
	ProfessionalSkillDto create(ProfessionalSkillDto professionalSkillDto);

	void delete(int id);

	ProfessionalSkillDto update(ProfessionalSkillDto professionalSkillDto);

	ProfessionalSkillDto find(int id);

	List<ProfessionalSkillDto> findAll();
	
	ProfessionalSkillTypesDto findTypes();

	ProfessionalSkillDto find(int activityId, String niveau);

}
