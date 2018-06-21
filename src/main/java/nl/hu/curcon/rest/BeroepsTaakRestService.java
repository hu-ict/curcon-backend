package nl.hu.curcon.rest;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;
import nl.hu.curcon.dto.competence.BeroepsTaakTypesDto;
import nl.hu.curcon.service.BeroepsTaakService;
import nl.hu.curcon.filter.FirebaseInit;

/**
 * @author berend.wilkens, 18 mei 2017
 */
@Component
@Path("/beroepstaken")
@Api(hidden = false, value = "[Beroepstaak] Beheer op de 75 beroepstaken. Alleen lezen en wijzigen, aanmaken en verwijderen zijn niet aan de orde.")
public class BeroepsTaakRestService {
    @Autowired
    BeroepsTaakService beroepsTaakService;
	@Autowired
	FirebaseInit firebaseInit;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<BeroepsTaakDto> findAll() {
		if (!firebaseInit.functionInUser("beroepstaken_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return beroepsTaakService.findAll();
	}
	
	@GET
	@Path("/{beroepsTaakId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public BeroepsTaakDto find(@PathParam("beroepsTaakId") int beroepsTaakId) {
		if (!firebaseInit.functionInUser("beroepstaak_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return beroepsTaakService.find(beroepsTaakId);
	}

 	@GET
 	@Path("/types")
	@Produces({ MediaType.APPLICATION_JSON })
	public BeroepsTaakTypesDto findTypes() {
		if (!firebaseInit.functionInUser("beroepstaaktypes_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return beroepsTaakService.findTypes();
	}

	@GET
	@Path("/activiteiten/{activiteitId}/architectuurlagen/{architectuurLaagId}/niveaus/{niveau}")
	@Produces({ MediaType.APPLICATION_JSON })
	public BeroepsTaakDto find(@PathParam("activiteitId") int activiteitId, @PathParam("architectuurLaagId") int architectuurLaagId, @PathParam("niveau") int niveau) {
		if (!firebaseInit.functionInUser("beroepstaak_find")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return beroepsTaakService.find(activiteitId, architectuurLaagId, niveau);
	}

}
