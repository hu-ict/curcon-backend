package nl.hu.curcon.rest;
import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.hu.curcon.dto.LeerlijnDto;
import nl.hu.curcon.dto.competence.TrefwoordDto;
import nl.hu.curcon.dto.post.LeerlijnPostDto;
import nl.hu.curcon.dto.post.TrefwoordPostDto;
import nl.hu.curcon.service.LeerlijnService;
import nl.hu.curcon.filter.FunctionChecker;

@Component
@Path("/leerlijnen")
@Api(hidden = true)
public class LeerlijnRestService {
    @Autowired
    LeerlijnService leerlijnService;
	@Autowired
	FunctionChecker functionChecker;

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public LeerlijnDto find(@PathParam("id") int id) {
		if (!functionChecker.functionInUser("leerlijn_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return leerlijnService.find(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public LeerlijnDto update(LeerlijnPostDto leerlijnDto) {
		if (!functionChecker.functionInUser("leerlijn_put")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return leerlijnService.update(leerlijnDto);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		if (!functionChecker.functionInUser("leerlijn_delete")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		leerlijnService.delete(id);
	}
	
	@GET
	@Path("/{leerlijnId}/trefwoorden")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public List<TrefwoordDto> findTrefwoordenByLeerlijn(@PathParam("leerlijnId") int leerlijnId) {
		if (!functionChecker.functionInUser("leerlijntrefwoorden_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return leerlijnService.findTrefwoordenByLeerlijn(leerlijnId);
	}

	@POST
	@Path("/{leerlijnId}/trefwoorden")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(value = "Maakt een nieuw trefwoord aan binnen een leerlijn.")
	public Response createTrefwoordByLeerlijn(@PathParam("leerlijnId") int leerlijnId, TrefwoordPostDto trefwoordDto) {
		if (!functionChecker.functionInUser("leerlijntrefwoord_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		int trefwoordId = leerlijnService.createTrefwoordByLeerlijn(leerlijnId, trefwoordDto);
		if (trefwoordId > 0) {
			UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl())
					.path("/trefwoorden/" + trefwoordId);
			URI uri = builder.build();
			return Response.status(201).contentLocation(uri).build();
		
		} else {
			return Response.status(404).build();
		}
	}

}
