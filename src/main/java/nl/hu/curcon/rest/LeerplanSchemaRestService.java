package nl.hu.curcon.rest;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.hu.curcon.dto.LeerdoelOverzichtDto;
import nl.hu.curcon.dto.LeerplanSchemaDto;
import nl.hu.curcon.dto.check.EctsGewichtNiveauDto;
import nl.hu.curcon.dto.check.ProfielDto;
import nl.hu.curcon.service.LeerplanSchemaService;
import nl.hu.curcon.filter.FunctionChecker;

@Component
@Path("/leerplanschemas")
@Api(value="[Leerplanschema] Voor het raadplegen van leerplanschema's")
public class LeerplanSchemaRestService {
	@Autowired
	LeerplanSchemaService leerplanSchemaService;
	@Autowired
	FunctionChecker functionChecker;
	
	@GET
	@Path("/{cohortId}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public LeerplanSchemaDto find(@PathParam("cohortId") int cohortId) {
		if (!functionChecker.functionInUser("leerplanschema_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return leerplanSchemaService.find(cohortId);
	}
	
	@GET
	@Path("/{cohortId}/profiel")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(hidden = false, value = "Geeft een berekend opleidingsprofiel voor een cohort.")
	public ProfielDto findProfiel(@PathParam("cohortId") int cohortId) {
		if (!functionChecker.functionInUser("leerplanschemaprofiel_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return leerplanSchemaService.getCalcProfile(cohortId);
	}
	
	@GET
	@Path("/{cohortId}/activiteiten/{activiteitId}/architectuurlagen/{architectuurlaagId}/leerdoelen")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public List<LeerdoelOverzichtDto> findLeerdoelenByCohortAndBeroepsTaak(@PathParam("cohortId") int cohortId, @PathParam("activiteitId") int activiteitId, @PathParam("architectuurlaagId") int architectuurlaagId) {
		if (!functionChecker.functionInUser("leerdoelencohortberoepstaak_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return leerplanSchemaService.findLeerdoelenByCohortAndBeroepsTaak(cohortId, activiteitId, architectuurlaagId);
	}
	
	@GET
	@Path("/{cohortId}/activiteiten/{activiteitId}/architectuurlagen/{architectuurlaagId}/ectsgewicht")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(hidden = false, value = "Geeft voor elke periode het ECTS gewicht voor een bepaalde beroepstaak.")
	public Map<Integer, Map<Integer, EctsGewichtNiveauDto>> calcEctsGewichtByCohortAndBeroepsTaak(@PathParam("cohortId") int cohortId, @PathParam("activiteitId") int activiteitId, @PathParam("architectuurlaagId") int architectuurlaagId) {
		if (!functionChecker.functionInUser("ECTScohortberoepstaak_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return leerplanSchemaService.calcEctsGewichtByCohortAndBeroepsTaak(cohortId, activiteitId, architectuurlaagId);
	}
	
	@GET
	@Path("/{cohortId}/check")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(hidden = false, value = "Geeft eventuele inconsistenties in het leerplanschema.")
	public Response checkProfiel(@PathParam("cohortId") int cohortId) {
		if (!functionChecker.functionInUser("leerplanschema_check")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<String> list = leerplanSchemaService.checkProfiel(cohortId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}
	

	

}
