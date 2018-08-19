package nl.hu.curcon.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import nl.hu.curcon.dto.ToetsElementDto;
import nl.hu.curcon.dto.post.ToetsElementPutDto;
import nl.hu.curcon.service.ToetsElementService;
import nl.hu.curcon.filter.FunctionChecker;

@Component
@Path("/toetselementen")
@Api(hidden = false, value="ToetsElementen vullen de feitelijke toetsmatrijs. "
		+"Ze vormen de koppeling tussen de leerdoelen en beoordelingselementen.")
public class ToetsElementRestService {
    @Autowired
    ToetsElementService toetsElementService;
	@Autowired
	FunctionChecker functionChecker;

	@GET
	@Path("/{toetsElementId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public ToetsElementDto find(@PathParam("toetsElementId") int id) {
		if (!functionChecker.functionInUser("toetselement_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return toetsElementService.find(id);
	}

	@PUT
	@Path("/{toetsElementId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(@PathParam("toetsElementId") int toetsElementId, ToetsElementPutDto toetsElementDto) {
		if (!functionChecker.functionInUser("toetselement_put")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (toetsElementService.update(toetsElementId, toetsElementDto)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
	}

	@DELETE
	@Path("/{toetsElementId}")
	public Response delete(@PathParam("toetsElementId") int toetsElementId) {
		if (!functionChecker.functionInUser("toetselement_delete")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (toetsElementService.delete(toetsElementId)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
	}
}
