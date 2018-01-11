/**
 * 
 */
package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.CohortDao;
import nl.hu.curcon.dao.CursusDao;
import nl.hu.curcon.domain.BeroepsTaak;
import nl.hu.curcon.domain.Cohort;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.domain.ToetsElement;
import nl.hu.curcon.dto.EctsBeroepsTaakDto;
import nl.hu.curcon.dto.EctsToetsVormDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.ToetsProgrammaService;

/**
 * @author berend.wilkens
 *
 */
@Service
public class ToetsProgrammaServiceImpl implements ToetsProgrammaService {

	@Autowired
	CohortDao cohortDao;
	@Autowired
	CursusDao cursusDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.hu.curcon.service.ToetsProgrammaService#getToetsVorm(int)
	 */
	@Override
	public List<EctsToetsVormDto> getEctsToetsVorm(int cohortId) {
		EctsToetsVormDto toetsVormDto = null;
		Cohort cohort = cohortDao.find(cohortId);
		Map<BeroepsTaak, EctsToetsVormDto> toetsVormen = new HashMap<>();
		for (Cursus cursus : cohort.getCursussen()) {
			for (Leerdoel leerdoel : cursus.getLeerdoelen()) {
				if (toetsVormen.containsKey(leerdoel.getBeroepsTaak())) {
					toetsVormDto = toetsVormen.get(leerdoel.getBeroepsTaak());
				} else {
					toetsVormDto = new EctsToetsVormDto();
					toetsVormDto.setBeroepsTaak(Domain2DtoMapper.map(leerdoel.getBeroepsTaak()));
					toetsVormen.put(leerdoel.getBeroepsTaak(), toetsVormDto);
				}
				for (ToetsElement toetsElement : leerdoel.getToetsElementen()) {
					String millerNiveau = toetsElement.getBeoordelingsElement().getToets().getMillerNiveau()
							.getNiveau();
					switch (millerNiveau) {
					case "Doen":
						toetsVormDto.addDoenEcts(toetsElement.getGewicht() * cursus.getEuropeanCredits()/100);
						break;
					case "Tonen":
						toetsVormDto.addTonenEcts(toetsElement.getGewicht() * cursus.getEuropeanCredits()/100);
						break;
					case "Toepassen":
						toetsVormDto.addToepassenEcts(toetsElement.getGewicht() * cursus.getEuropeanCredits()/100);
						break;
					case "Weten":
						toetsVormDto.addWetenEcts(toetsElement.getGewicht() * cursus.getEuropeanCredits()/100);
						break;
					}
				}
			}
		}
		return new ArrayList<EctsToetsVormDto>(toetsVormen.values());
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.hu.curcon.service.ToetsProgrammaService#getToetsVorm(int)
	 */
	@Override
	public List<EctsBeroepsTaakDto> getEctsBroepsTaak(int cohortId) {
		EctsBeroepsTaakDto ectsBeroepsTaakDto = null;
		Cohort cohort = cohortDao.find(cohortId);
		Map<BeroepsTaak, EctsBeroepsTaakDto> beroepsTaken = new HashMap<>();
		for (Cursus cursus : cohort.getCursussen()) {
			for (Leerdoel leerdoel : cursus.getLeerdoelen()) {
				if (beroepsTaken.containsKey(leerdoel.getBeroepsTaak())) {
					ectsBeroepsTaakDto = beroepsTaken.get(leerdoel.getBeroepsTaak());
				} else {
					ectsBeroepsTaakDto = new EctsBeroepsTaakDto();
					ectsBeroepsTaakDto.setBeroepsTaak(Domain2DtoMapper.map(leerdoel.getBeroepsTaak()));
					beroepsTaken.put(leerdoel.getBeroepsTaak(), ectsBeroepsTaakDto);
				}
				ectsBeroepsTaakDto.addEcts(leerdoel.getGewicht() * cursus.getEuropeanCredits()/100);
			}
		}
		return new ArrayList<EctsBeroepsTaakDto>(beroepsTaken.values());
	}

}
