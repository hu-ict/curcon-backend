package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.EctsBeroepsTaakDto;
import nl.hu.curcon.dto.EctsToetsVormDto;

public interface ToetsProgrammaService {

	List<EctsToetsVormDto> getEctsToetsVorm(int cohortId);

	List<EctsBeroepsTaakDto> getEctsBroepsTaak(int cohortId);

}
