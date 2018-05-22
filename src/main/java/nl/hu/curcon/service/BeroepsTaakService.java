package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.competence.BeroepsTaakDto;
import nl.hu.curcon.dto.competence.BeroepsTaakTypesDto;

/**
 * Created by Niels on 13-6-2015.
 */
public interface BeroepsTaakService {

	BeroepsTaakDto find(int id);

	List<BeroepsTaakDto> findAll();

	BeroepsTaakTypesDto findTypes();

	BeroepsTaakDto find(int activiteitId, int architectuurLaagId, int niveau);
}
