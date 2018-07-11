package nl.hu.curcon.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.hu.curcon.dto.DocentDto;
import nl.hu.curcon.dto.post.DocentPostDto;
import nl.hu.curcon.service.DocentService;
import nl.hu.curcon.filter.FunctionChecker;

/**
 * @author berend.wilkens, 12 apr. 2017
 * DocentRestService
 */
@Component
@Path("/docenten")
@Api(hidden = false, value = "[Docent] Raadplegen en wijzigen van een docent.")
public class DocentRestService {

    @Autowired
    DocentService docentService;
    @Autowired
    FunctionChecker functionChecker;
    
	@GET
	@Path("/{docentId}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(value = "Geeft een docent op basis van id.")
	public Response find(@PathParam("docentId") int id)  {
		if (!functionChecker.functionInUser("docent_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		DocentDto dto = docentService.find(id);
		if (dto != null) {
			return Response.ok(dto).build();
		} else {
			return Response.status(404).build();
		}
	}

	@PUT
	@Consumes({MediaType.APPLICATION_JSON })
	@Path("/{docentId}")
	@Transactional
	@ApiOperation(value = "Wijzigt een docent.")
	public Response update(@PathParam("docentId") int docentId, DocentPostDto docentDto) {
		if (!functionChecker.functionInUser("docent_put")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (docentService.update(docentId, docentDto)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
	}

//	@DELETE
//	@Path("/{docentId}")
//	@Transactional
//	@ApiOperation(hidden=true, value = "Verwijdert een docent, gebruik de api via organisatie.")
//	public Response delete(@PathParam("docentId") int id) {
//		DocentDto dto = docentService.find(id);
//		if (dto == null) {
//			return Response.status(404).build();
//
//		} else {
//			docentService.delete(dto.getId());
//			return Response.status(200).build();
//		}
//	}

}

