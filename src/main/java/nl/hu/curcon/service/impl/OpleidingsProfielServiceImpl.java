package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.BeroepsTaakDao;
import nl.hu.curcon.dao.OpleidingsProfielDao;
import nl.hu.curcon.dao.ProfessionalSkillDao;
import nl.hu.curcon.domain.Cohort;
import nl.hu.curcon.domain.Leerlijn;
import nl.hu.curcon.domain.OpleidingsProfiel;
import nl.hu.curcon.domain.Organisatie;
import nl.hu.curcon.domain.ProfessionalSkill;
import nl.hu.curcon.domain.hboi.BeroepsTaak;
import nl.hu.curcon.dto.CohortDto;
import nl.hu.curcon.dto.LeerlijnDto;
import nl.hu.curcon.dto.OpleidingsProfielDto;
import nl.hu.curcon.dto.check.OpleidingBeroepsTaakValidatieDto;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillDto;
import nl.hu.curcon.dto.post.CohortPostDto;
import nl.hu.curcon.dto.post.OpleidingsProfielPostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.CohortService;
import nl.hu.curcon.service.OpleidingsProfielService;

/**
 * @author berend.wilkens, 1 mei 2017
 */
@Service
public class OpleidingsProfielServiceImpl extends GenericService implements OpleidingsProfielService {
	@Autowired
	private OpleidingsProfielDao opleidingsProfielDao;
	@Autowired
	private CohortService cohortService;
	@Autowired
	private BeroepsTaakDao beroepsTaakDao;
	@Autowired
	private ProfessionalSkillDao professionalSkillDao;

	@Override
	public OpleidingsProfielDto find(int id) {
		OpleidingsProfiel d = opleidingsProfielDao.find(id);
		return Domain2DtoMapper.map(d);
	}

	@Override
	public List<OpleidingsProfielDto> findAll() {
		List<OpleidingsProfielDto> dtos = new ArrayList<OpleidingsProfielDto>();
		List<OpleidingsProfiel> opleidingsProfielen = opleidingsProfielDao.findAll();
		for (OpleidingsProfiel d : opleidingsProfielen) {
			dtos.add(Domain2DtoMapper.map(d));
		}
		return dtos;
	}

	@Override
	public int create(Organisatie organisatie, OpleidingsProfielPostDto opleidingsProfielDto) {
		OpleidingsProfiel opleidingsProfiel = dto2DomainMapper.map(opleidingsProfielDto);
		opleidingsProfiel.setOrganisatie(organisatie);
		opleidingsProfiel = opleidingsProfielDao.save(opleidingsProfiel);
		return opleidingsProfiel.getId();
	}

	@Override
	public void delete(int opleidingsProfielId) {
		opleidingsProfielDao.delete(opleidingsProfielId);
	}

	@Override
	public boolean update(int opleidingsProfielId, OpleidingsProfielPostDto opleidingsProfielDto) {
		OpleidingsProfiel opleidingsProfiel = opleidingsProfielDao.find(opleidingsProfielId);
		opleidingsProfiel.setNaam(opleidingsProfielDto.getNaam());
		opleidingsProfielDao.update(opleidingsProfiel);
		return true;
	}

	@Override
	public int createCohortByOpleidingsProfiel(int opleidingsProfielId, CohortPostDto cohortDto) {
		OpleidingsProfiel opleidingsProfiel = opleidingsProfielDao.find(opleidingsProfielId);
		if (opleidingsProfiel == null)
			return 0;
		return cohortService.create(opleidingsProfiel, cohortDto);
	}

	@Override
	public List<CohortDto> findCohortenByOpleidingsProfiel(int opleidingsProfielId) {
		OpleidingsProfiel opleidingsProfiel = opleidingsProfielDao.find(opleidingsProfielId);
		if (opleidingsProfiel == null)
			return null;
		List<CohortDto> cohorten = new ArrayList<>();
		for (Cohort cohort : opleidingsProfiel.getCohorten()) {
			cohorten.add(Domain2DtoMapper.map(cohort));
		}
		return cohorten;
	}

	@Override
	public List<BeroepsTaakDto> findBeroepsTakenByOpleidingsProfiel(int opleidingsProfielId) {
		OpleidingsProfiel opleidingsProfiel = opleidingsProfielDao.find(opleidingsProfielId);
		if (opleidingsProfiel == null)
			return null;
		List<BeroepsTaakDto> beroepsTaken = new ArrayList<>();
		for (BeroepsTaak beroepsTaak : opleidingsProfiel.getEindBTs()) {
			beroepsTaken.add(Domain2DtoMapper.map(beroepsTaak));
		}
		return beroepsTaken;
	}

	@Override
	public List<ProfessionalSkillDto> findProfessionalSkillsByOpleidingsProfiel(int opleidingsProfielId) {
		OpleidingsProfiel opleidingsProfiel = opleidingsProfielDao.find(opleidingsProfielId);
		if (opleidingsProfiel == null)
			return null;
		List<ProfessionalSkillDto> professionalSkills = new ArrayList<>();
		for (ProfessionalSkill professionalSkill : opleidingsProfiel.getEindPSs()) {
			professionalSkills.add(Domain2DtoMapper.map(professionalSkill));
		}
		return professionalSkills;
	}

	@Override
	public List<LeerlijnDto> findLeerlijnenByOpleidingsProfiel(int opleidingsProfielId) {
		OpleidingsProfiel opleidingsProfiel = opleidingsProfielDao.find(opleidingsProfielId);
		if (opleidingsProfiel == null)
			return null;
		List<LeerlijnDto> leerlijnDtos = new ArrayList<>();
		for (Leerlijn leerlijn : opleidingsProfiel.getLeerlijnen()) {
			leerlijnDtos.add(Domain2DtoMapper.map(leerlijn));
		}
		return leerlijnDtos;
	}

	@Override
	public boolean addBeroepsTaakToOpleidingsProfiel(int opleidingsProfielId, int beroepsTaakId) {
		OpleidingsProfiel opleidingsProfiel = opleidingsProfielDao.find(opleidingsProfielId);
		if (opleidingsProfiel == null)
			return false;
		BeroepsTaak beroepsTaak = beroepsTaakDao.find(beroepsTaakId);
		if (beroepsTaak == null)
			return false;
		if (opleidingsProfiel.getEindBTs().contains(beroepsTaak))
			return false;
		opleidingsProfiel.getEindBTs().add(beroepsTaak);
		opleidingsProfielDao.save(opleidingsProfiel);
		return true;
	}

	@Override
	public boolean removeBeroepsTaakFromOpleidingsProfiel(int opleidingsProfielId, int beroepstaakId) {
		OpleidingsProfiel c = opleidingsProfielDao.find(opleidingsProfielId);
		if (c == null)
			return false;
		BeroepsTaak b = beroepsTaakDao.find(beroepstaakId);
		if (b == null)
			return false;
		if (!c.getEindBTs().contains(b))
			return false;
		c.getEindBTs().remove(b);
		opleidingsProfielDao.save(c);
		return true;
	}

	@Override
	public boolean addProfessionalSkillsToOpleidingsProfiel(int opleidingsProfielId, int professionalskillId) {
		OpleidingsProfiel o = opleidingsProfielDao.find(opleidingsProfielId);
		if (o == null)
			return false;
		ProfessionalSkill p = professionalSkillDao.find(professionalskillId);
		if (p == null)
			return false;
		if (o.getEindBTs().contains(p))
			return false;
		o.getEindPSs().add(p);
		opleidingsProfielDao.save(o);
		return true;
	}

	@Override
	public boolean removeProfessionalSkillsFromOpleidingsProfiel(int opleidingsProfielId, int professionalskillId) {
		OpleidingsProfiel o = opleidingsProfielDao.find(opleidingsProfielId);
		if (o == null)
			return false;
		ProfessionalSkill p = professionalSkillDao.find(professionalskillId);
		if (p == null)
			return false;
		if (!o.getEindPSs().contains(p))
			return false;
		o.getEindPSs().remove(p);
		opleidingsProfielDao.save(o);
		return true;
	}

	@Override
	public OpleidingBeroepsTaakValidatieDto validateBeroepsTakenByOpleidingsProfiel(int opleidingsProfielId) {
		OpleidingsProfiel opleidingsProfiel = opleidingsProfielDao.find(opleidingsProfielId);
		if (opleidingsProfiel == null)
			return null;
		for (BeroepsTaak beroepsTaak : opleidingsProfiel.getEindBTs()) {
			switch (beroepsTaak.getNiveau()) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			}
		}
		return null;
	}

}
