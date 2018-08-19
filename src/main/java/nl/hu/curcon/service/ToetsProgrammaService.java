package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.check.ConformiteitBeroepsTaakDto;
import nl.hu.curcon.dto.check.EctsBeroepsTaakDto;
import nl.hu.curcon.dto.check.EctsToetsVormDto;

public interface ToetsProgrammaService {

	List<EctsToetsVormDto> getEctsToetsVorm(int cohortId);

	List<EctsBeroepsTaakDto> getEctsBroepsTaak(int cohortId);

	List<ConformiteitBeroepsTaakDto> calcProfile(int cohortId);

}
