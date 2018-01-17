package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.CursusDto;
import nl.hu.curcon.dto.LeerdoelDto;
import nl.hu.curcon.dto.ToetsDto;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillDto;
import nl.hu.curcon.dto.post.CursusPostDto;
import nl.hu.curcon.dto.post.LeerdoelPostDto;
import nl.hu.curcon.dto.post.ToetsPostDto;

/**
 * @author berend.wilkens, 20 apr. 2017
 * CursusService
 */
public interface CursusService {
//	CursusDto create(CursusDto cursusDto);

	void delete(int cursusId);

	boolean update(int cursusId, CursusPostDto cursusDto);

	CursusDto find(int cursusId);

	List<CursusDto> findAll();
	
	List<LeerdoelDto> getLeerdoelenByCursus(int cursusId);

	List<ToetsDto> getToetsenByCursus(int cursusId);

	boolean addBeroepsTaakToCursus(int cursusId, int beroepsTaakId);

	boolean removeBeroepsTaakFromCursus(int cursusId, int beroepstaakId);

	boolean setDocentToCursus(int cursusId, int docentId);

	List<BeroepsTaakDto> getBeroepsTakenByCursus(int cursusId);

	int createToetsByCursus(int cursusId, ToetsPostDto toetsDto);
	
	int createLeerdoelByCursus(int cursusId, LeerdoelPostDto leerdoelDto);

	boolean removeProfessionalSkillFromCursus(int cursusId, int professionalskillId);

	boolean addProfessionalSkillToCursus(int cursusId, int id);

	List<ProfessionalSkillDto> getProfessionalSkillsByCursus(int id);

	List<String> check(int cursusId);
}
