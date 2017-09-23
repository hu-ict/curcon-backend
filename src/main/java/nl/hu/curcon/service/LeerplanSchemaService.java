package nl.hu.curcon.service;

import java.util.List;
import java.util.Map;

import nl.hu.curcon.dto.EctsGewichtNiveauDto;
import nl.hu.curcon.dto.LeerdoelOverzichtDto;
import nl.hu.curcon.dto.LeerplanSchemaDto;
import nl.hu.curcon.dto.ProfielDto;

/**
 * @author berend.wilkens
 *
 */
public interface LeerplanSchemaService {
	LeerplanSchemaDto find(int cohortId);

	List<LeerdoelOverzichtDto> findLeerdoelenByCohortAndBeroepsTaak(int cohortId, int activiteitId, int architectuurlaagId);

	Map<Integer, Map<Integer, EctsGewichtNiveauDto>> calcEctsGewichtByCohortAndBeroepsTaak(int cohortId, int activiteitId, int architectuurlaagId);

	ProfielDto getCalcProfile(int cohortId);
}