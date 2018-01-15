/**
 * 
 */
package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.BeroepsTaakDao;
import nl.hu.curcon.dao.CohortDao;
import nl.hu.curcon.dao.CursusDao;
import nl.hu.curcon.domain.BeroepsTaak;
import nl.hu.curcon.domain.Cohort;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.domain.ToetsElement;
import nl.hu.curcon.dto.BeroepsTaakDto;
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
	public static int ECTS_INSPANNING_NIVEAU_1 = 8;
	public static int ECTS_INSPANNING_NIVEAU_2 = 14;
	public static int ECTS_INSPANNING_NIVEAU_3 = 19;
	public static int ECTS_INSPANNING_NIVEAU_1_DIV = 2;
	public static int ECTS_INSPANNING_NIVEAU_2_DIV = 3;
	public static int ECTS_INSPANNING_NIVEAU_3_DIV = 4;
	public static int NIET_AANGEWERKT = 1; // rood
	public static int NIET_OP_NIVEAU = 2; // oranje
	public static int ONDER_NIVEAU = 3; // geel
	public static int OP_NIVEAU = 4; // groen
	public static int BOVEN_NIVEAU = 5; // paars

	@Autowired
	CohortDao cohortDao;
	@Autowired
	CursusDao cursusDao;
	@Autowired
	BeroepsTaakDao beroepsTaakDao;

	Logger logger = LoggerFactory.getLogger(ToetsProgrammaServiceImpl.class);

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
						toetsVormDto.addDoenEcts(toetsElement.getGewicht() * cursus.getEuropeanCredits() / 100);
						break;
					case "Tonen":
						toetsVormDto.addTonenEcts(toetsElement.getGewicht() * cursus.getEuropeanCredits() / 100);
						break;
					case "Toepassen":
						toetsVormDto.addToepassenEcts(toetsElement.getGewicht() * cursus.getEuropeanCredits() / 100);
						break;
					case "Weten":
						toetsVormDto.addWetenEcts(toetsElement.getGewicht() * cursus.getEuropeanCredits() / 100);
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
				ectsBeroepsTaakDto.addEcts(leerdoel.getGewicht() * cursus.getEuropeanCredits() / 100);
			}
		}
		return new ArrayList<EctsBeroepsTaakDto>(beroepsTaken.values());
	}

	@Override
	public List<BeroepsTaakDto> calcProfile(int cohortId) {
		EctsBeroepsTaakDto ectsBeroepsTaakDto = null;
		Cohort cohort = cohortDao.find(cohortId);
//		cohort.getOpleidingsProfiel().getEindBTs();
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
				ectsBeroepsTaakDto.addEcts(leerdoel.getGewicht() / 100 * cursus.getEuropeanCredits());
			}
		}
		Map<BeroepsTaak,BeroepsTaakDto> beroepsTakenResult = new HashMap<>();
		for (BeroepsTaak beroepsTaak : cohort.getOpleidingsProfiel().getEindBTs()) {
			int resultaat1 = NIET_AANGEWERKT;
			int resultaat2 = NIET_AANGEWERKT;
			int resultaat3 = NIET_AANGEWERKT;
			int resultaat = NIET_AANGEWERKT;
			logger.info("beroepsTaak " + beroepsTaak);
			
			BeroepsTaak  beroepsTaakLoop = beroepsTaakDao.find(beroepsTaak.getActiviteit().getId(), beroepsTaak.getArchitectuurlaag().getId(), 3);
			if (beroepsTaakLoop.getNiveau() == 3) {
				resultaat3 = analyseerBeroepsTaak(beroepsTaken, beroepsTaakLoop);
				beroepsTaakLoop = beroepsTaakDao.find(beroepsTaak.getActiviteit().getId(), beroepsTaak.getArchitectuurlaag().getId(), 2);
			}
			if (beroepsTaakLoop.getNiveau() == 2) {
				resultaat2 = analyseerBeroepsTaak(beroepsTaken, beroepsTaakLoop);
				beroepsTaakLoop = beroepsTaakDao.find(beroepsTaak.getActiviteit().getId(), beroepsTaak.getArchitectuurlaag().getId(), 1);
			}
			if (beroepsTaakLoop.getNiveau() == 1) {
				resultaat1 = analyseerBeroepsTaak(beroepsTaken, beroepsTaakLoop);
			}
			if (beroepsTaak.getNiveau() == 3){
				if (resultaat3 == NIET_AANGEWERKT && resultaat2 == NIET_AANGEWERKT && resultaat1 == NIET_AANGEWERKT) {
					resultaat = NIET_AANGEWERKT;
				} else if (resultaat3 == NIET_AANGEWERKT) {
					resultaat = NIET_OP_NIVEAU;
				} else if (resultaat3 == OP_NIVEAU && resultaat2 == OP_NIVEAU && resultaat1 == OP_NIVEAU) {
					resultaat = OP_NIVEAU;
				} else if (resultaat3 == ONDER_NIVEAU || resultaat2 == ONDER_NIVEAU || resultaat1 == ONDER_NIVEAU) {
					resultaat = ONDER_NIVEAU;
				} else if (resultaat3 == BOVEN_NIVEAU || resultaat2 == BOVEN_NIVEAU || resultaat1 == BOVEN_NIVEAU) {
					resultaat = BOVEN_NIVEAU;
				} 
				
			}
			if (beroepsTaak.getNiveau() == 2){
				if (resultaat2 == NIET_AANGEWERKT && resultaat1 == NIET_AANGEWERKT) {
					resultaat = NIET_AANGEWERKT;
				} else if (resultaat2 == NIET_AANGEWERKT) {
					resultaat = NIET_OP_NIVEAU;
				} else if (resultaat2 == OP_NIVEAU && resultaat1 == OP_NIVEAU) {
					resultaat = OP_NIVEAU;
				} else if (resultaat2 == ONDER_NIVEAU || resultaat1 == ONDER_NIVEAU) {
					resultaat = ONDER_NIVEAU;
				} else if (resultaat2 == BOVEN_NIVEAU || resultaat1 == BOVEN_NIVEAU) {
					resultaat = BOVEN_NIVEAU;
				} 
			}
			
			if (beroepsTaak.getNiveau() == 1){
				resultaat = resultaat1;				
			}
			
			beroepsTaak.setNiveau(resultaat);
			beroepsTakenResult.put(beroepsTaak, Domain2DtoMapper.map(beroepsTaak));

		};

		return new ArrayList<BeroepsTaakDto>(beroepsTakenResult.values());
	}

	private int analyseerBeroepsTaak(Map<BeroepsTaak, EctsBeroepsTaakDto> beroepsTaken, BeroepsTaak beroepsTaak) 
	{
		if (beroepsTaken.containsKey(beroepsTaak)) {
			EctsBeroepsTaakDto ectsBeroepsTaakDto = beroepsTaken.get(beroepsTaak);
			if (ectsBeroepsTaakDto.getEcts() < (ECTS_INSPANNING_NIVEAU_3 - ECTS_INSPANNING_NIVEAU_3_DIV)) {
				return ONDER_NIVEAU;
			} else if (ectsBeroepsTaakDto.getEcts() < (ECTS_INSPANNING_NIVEAU_3 - ECTS_INSPANNING_NIVEAU_3_DIV)) {
				return BOVEN_NIVEAU;
			} else {
				return OP_NIVEAU;
			}
		} else {
			return NIET_AANGEWERKT;
		}
	}

}
