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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.hu.curcon.dto.BeoordelingsElementDto;
import nl.hu.curcon.dto.ToetsDto;
import nl.hu.curcon.dto.post.BeoordelingsElementPostDto;
import nl.hu.curcon.dto.post.ToetsPostDto;
import nl.hu.curcon.service.ToetsService;
import nl.hu.curcon.filter.FirebaseInit;

@Component
@Path("/toetsen")
@Api(hidden = false, value="[Toets] Raadplegen en wijzigen van toetsen")
public class ToetsRestService {
    @Autowired
    ToetsService toetsService;
	@Autowired
	FirebaseInit firebaseInit;

	@GET
	@Path("/{toetsId}")
	@Transactional
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft een toets op basis van zijn id")
	public Response find(@PathParam("toetsId") int toetsId) {
		if (!firebaseInit.functionInUser("toets_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		ToetsDto dto = toetsService.find(toetsId);
		if (dto != null) {
			return Response.ok(dto).build();
		} else {
			return Response.status(404).build();
		}
	}

	@PUT
	@Path("/{toetsId}")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Doet een update op een bestaande toets.")
	public Response update(@PathParam("toetsId") int toetsId, ToetsPostDto toetsDto) {
		if (!firebaseInit.functionInUser("toets_put")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (toetsService.update(toetsId, toetsDto)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
	}

	@DELETE
	@Path("/{toetsId}")
	@Transactional
	@ApiOperation(value="Verwijderd een toets met zijn beoordelingselementen.")
	public Response delete(@PathParam("toetsId") int toetsId) {
		if (!firebaseInit.functionInUser("toets_delete")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		ToetsDto dto = toetsService.find(toetsId);
		if (dto == null) {
			return Response.status(404).build();

		} else {
			toetsService.delete(dto.getId());
			return Response.status(200).build();
		}
	}

	@POST
	@Path("/{toetsId}/beoordelingselementen")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(value = "Maakt een nieuwe beoordelingselement aan binnen een toets.")
	public Response createBeoordelingselementByToets(@PathParam("toetsId") int toetsId, BeoordelingsElementPostDto beoordelingsElementPostDto) {
		if (!firebaseInit.functionInUser("toetsbeoordelingselement_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		int beoordelingsElementId = toetsService.createBeoordelingsElementByToets(toetsId, beoordelingsElementPostDto);
		if (beoordelingsElementId > 0) {
			UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl())
					.path("/beoordelingselementen/" + beoordelingsElementId);
			URI uri = builder.build();
			return Response.status(201).contentLocation(uri).build();
		
		} else {
			return Response.status(404).build();
		}
	}

	@GET
	@Path("/{toetsId}/beoordelingselementen")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(value = "Geeft een lijst met alle trefwoorden binnen een leerlijn.")
	public Response findBeoordelingsElementenByToets(@PathParam("toetsId") int toetsId) {
		if (!firebaseInit.functionInUser("toetsbeoordelingselementen_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<BeoordelingsElementDto> list = toetsService.findBeoordelingsElementenByToets(toetsId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}
}
