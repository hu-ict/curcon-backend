package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.CohortDao;
import nl.hu.curcon.dao.CursusDao;
import nl.hu.curcon.domain.Cohort;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.OpleidingsProfiel;
import nl.hu.curcon.dto.CohortDto;
import nl.hu.curcon.dto.CursusDto;
import nl.hu.curcon.dto.post.CohortPostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.CohortService;

/**
 * @author berend.wilkens, 23 mrt. 2017 CohortServiceImpl
 */
@Service
public class CohortServiceImpl extends GenericService implements CohortService {
	@Autowired
	private CohortDao cohortDao;
	@Autowired
	private CursusDao cursusDao;

	@Override
	public int create(OpleidingsProfiel opleidingsProfiel, CohortPostDto cohortDto) {
		Cohort cohort = dto2DomainMapper.map(cohortDto);
		cohort.setOpleidingsProfiel(opleidingsProfiel);
		cohort = cohortDao.save(cohort);
		return cohort.getId();
	}

	@Override
	public void delete(int cohortId) {
		cohortDao.delete(cohortId);
	}

	@Override
	@Transactional
	public boolean update(int cohortId, CohortPostDto cohortDto) {
		Cohort cohort = dto2DomainMapper.map(cohortDto);
		cohortDao.update(cohort);
		return true;
	}

	@Override
	@Transactional
	public CohortDto find(int cohortId) {
		Cohort d = cohortDao.find(cohortId);
		return Domain2DtoMapper.map(d);
	}

	@Override
	@Transactional
	public List<CohortDto> findAll() {
		List<CohortDto> dtos = new ArrayList<CohortDto>();
		List<Cohort> cohorten = cohortDao.findAll();
		for (Cohort d : cohorten) {
			dtos.add(Domain2DtoMapper.map(d));
		}
		return dtos;
	}

	@Override
	public List<CursusDto> getCursussenByCohort(int cohortId) {
		Cohort cohort = cohortDao.find(cohortId);
		if (cohort == null)
			return null;
		List<CursusDto> cursussen = new ArrayList<>();
		for (Cursus cursus : cohort.getCursussen()) {
			cursussen.add(Domain2DtoMapper.map(cursus));
		}
		return cursussen;
	}

	@Override
	public boolean removeCursusFromCohort(int cohortId, int cursusId) {
        Cohort c = cohortDao.find(cohortId);
        if (c == null) return false;
        Cursus cursus = cursusDao.find(cursusId);
        if (cursus == null) return false;
        if (!c.getCursussen().contains(cursus)) return false;
        c.getCursussen().remove(cursus);
        cohortDao.save(c);
        return true;
	}

	@Override
	public boolean addCursusToCohort(int cohortId, int cursusId) {
        Cohort cohort = cohortDao.find(cohortId);
        if (cohort == null) return false;
        Cursus cursus = cursusDao.find(cursusId);
        if (cursus == null) return false;
        if (!cohort.getOpleidingsProfiel().getOrganisatie().getCursussen().contains(cursus)) return false;
        if (cohort.getCursussen().contains(cursus)) return false;
        cohort.getCursussen().add(cursus);
        cohortDao.save(cohort);
        return true;
	}

}
