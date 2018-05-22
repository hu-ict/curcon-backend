package nl.hu.curcon.dao;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.domain.ProfessionalSkill;

/**
 * @author berend.wilkens, 19 jun. 2017
 */
@Repository
public interface ProfessionalSkillDao extends GenericDao<ProfessionalSkill> {
	ProfessionalSkill find(int activiteitId, String niveau);
}
