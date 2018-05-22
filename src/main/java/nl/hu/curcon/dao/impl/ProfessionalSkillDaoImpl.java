package nl.hu.curcon.dao.impl;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.dao.ProfessionalSkillDao;
import nl.hu.curcon.domain.ProfessionalSkill;

/**
 * @author berend.wilkens, 19 jun. 2017
 */
@Repository
public class ProfessionalSkillDaoImpl extends GenericDaoImpl<ProfessionalSkill> implements ProfessionalSkillDao {

	@Override
	public ProfessionalSkill find(int activiteitId, String niveau) {
		String query = "select ps "
				+ "from ProfessionalSkill as ps "
				+ "where ps.activiteit.id = " + activiteitId + " "
				+ "and ps.niveau = '" + niveau + "'";
        return (ProfessionalSkill) this.em.createQuery(query).getSingleResult();
	}

}
