package nl.hu.curcon.rest;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.hu.curcon.dto.EctsGewichtNiveauDto;
import nl.hu.curcon.dto.LeerdoelOverzichtDto;
import nl.hu.curcon.dto.LeerplanSchemaDto;
import nl.hu.curcon.dto.ProfielDto;
import nl.hu.curcon.service.LeerplanSchemaService;

@Component
@Path("/leerplanschemas")
@Api(value="[Leerplanschema] Voor het raadplegen van leerplanschema's")
public class LeerplanSchemaRestService {
	@Autowired
	LeerplanSchemaService leerplanSchemaService;

	@GET
	@Path("/{cohortId}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public LeerplanSchemaDto find(@PathParam("cohortId") int cohortId) {
		return leerplanSchemaService.find(cohortId);
	}
	
	@GET
	@Path("/{cohortId}/profiel")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(hidden = false, value = "Geeft een berekend opleidingsprofiel voor een cohort.")
	public ProfielDto findProfiel(@PathParam("cohortId") int cohortId) {
		return leerplanSchemaService.getCalcProfile(cohortId);
	}
	
	@GET
	@Path("/{cohortId}/activiteiten/{activiteitId}/architectuurlagen/{architectuurlaagId}/leerdoelen")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public List<LeerdoelOverzichtDto> findLeerdoelenByCohortAndBeroepsTaak(@PathParam("cohortId") int cohortId, @PathParam("activiteitId") int activiteitId, @PathParam("architectuurlaagId") int architectuurlaagId) {
		return leerplanSchemaService.findLeerdoelenByCohortAndBeroepsTaak(cohortId, activiteitId, architectuurlaagId);
	}
	
	@GET
	@Path("/{cohortId}/activiteiten/{activiteitId}/architectuurlagen/{architectuurlaagId}/ectsgewicht")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(hidden = false, value = "Geeft voor elke periode het ECTS gewicht voor een bepaalde beroepstaak.")
	public Map<Integer, Map<Integer, EctsGewichtNiveauDto>> calcEctsGewichtByCohortAndBeroepsTaak(@PathParam("cohortId") int cohortId, @PathParam("activiteitId") int activiteitId, @PathParam("architectuurlaagId") int architectuurlaagId) {
		return leerplanSchemaService.calcEctsGewichtByCohortAndBeroepsTaak(cohortId, activiteitId, architectuurlaagId);
	}
	

}
