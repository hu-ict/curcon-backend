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
import nl.hu.curcon.dto.CursusDto;
import nl.hu.curcon.dto.DocentDto;
import nl.hu.curcon.dto.OpleidingsProfielDto;
import nl.hu.curcon.dto.OrganisatieDto;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;
import nl.hu.curcon.dto.post.CursusPostDto;
import nl.hu.curcon.dto.post.DocentPostDto;
import nl.hu.curcon.dto.post.OpleidingsProfielPostDto;
import nl.hu.curcon.dto.post.OrganisatiePostDto;
import nl.hu.curcon.service.OrganisatieService;
import nl.hu.curcon.filter.FirebaseInit;

@Component
@Path("/organisaties")
@Api(value = "[Organisatie] Organisatie is het hoogste niveau, hier hangen de opleidingen, cursussen en docenten onder.")
public class OrganisatieRestService {
	@Autowired
	OrganisatieService organisatieService;
	@Autowired
	FirebaseInit firebaseInit;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft een lijst met alle organisaties.")
	public List<OrganisatieDto> findAll() {
		if (!firebaseInit.functionInUser("organisaties_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return organisatieService.findAll();
	}

	@GET
	@Path("/{organisatieId}")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft een bepaalde organisatie.")
	public Response find(@PathParam("organisatieId") int organisatieId) {
		if (!firebaseInit.functionInUser("organisatie_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		OrganisatieDto dto = organisatieService.find(organisatieId);
		if (dto != null) {
			return Response.ok(dto).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Maakt een nieuwe organisatie aan.")
	public Response create(OrganisatiePostDto organisatieDto) {
		if (!firebaseInit.functionInUser("organisatie_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		int organisatieId = organisatieService.create(organisatieDto);
		if (organisatieId > 0) {
			UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl()).path("organisaties/" + organisatieId);
			URI uri = builder.build();
			return Response.status(201).contentLocation(uri).build();
		} else {
			return Response.status(404).build();
		}
	}

	@PUT
	@Path("/{organisatieId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Wijzigd de naam van een organisatie.")
	public Response update(@PathParam("organisatieId") int organisatieId, OrganisatiePostDto organisatieDto) {
		if (!firebaseInit.functionInUser("organisatie_put")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (organisatieService.update(organisatieId, organisatieDto)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
	}

	@DELETE
	@Path("/{organisatieId}")
	@ApiOperation(hidden = true, value = "Verwijdert een complete organisatie, inclussief alle docenten, cursussen en opleidingsprofielen.")
	public Response delete(@PathParam("organisatieId") int organisatieId) {
		if (!firebaseInit.functionInUser("organisatie_delete")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (organisatieService.delete(organisatieId)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
	}

	@GET
	@Path("/{organisatieId}/docenten")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft een lijst met alle docenten binnen een organisatie.")
	public Response findDocentenByOrganisatie(@PathParam("organisatieId") int organisatieId) {
		if (!firebaseInit.functionInUser("organisatiedocenten_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<DocentDto> list = organisatieService.findDocentenByOrganisatie(organisatieId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path("/{organisatieId}/docenten")
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Maakt een nieuwe docent aan binnen een organisatie.")
	public Response createDocentByOrganisatie(@PathParam("organisatieId") int organisatieId, DocentPostDto docentDto) {
		if (!firebaseInit.functionInUser("organisatiedocent_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		int docentId = organisatieService.createDocentByOrganisatie(organisatieId, docentDto);
		if (docentId > 0) {
			UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl()).path("/docenten/" + docentId);
			URI uri = builder.build();
			return Response.status(201).contentLocation(uri).build();

		} else {
			return Response.status(404).build();
		}
	}

	@GET
	@Path("/{organisatieId}/cursussen")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft een lijst met alle cursussen binnen een organisatie.")
	public Response findCursussenByOrganisatie(@PathParam("organisatieId") int organisatieId) {
		if (!firebaseInit.functionInUser("organisatiecursussen_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<CursusDto> list = organisatieService.findCursussenByOrganisatie(organisatieId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path("/{organisatieId}/cursussen")
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Maakt een nieuwe cursus aan binnen een organisatie.")
	public Response createCursusByOrganisatie(@PathParam("organisatieId") int organisatieId, CursusPostDto cursusDto) {
		if (!firebaseInit.functionInUser("organisatiecursus_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		int cursusId = organisatieService.createCursusByOrganisatie(organisatieId, cursusDto);
		if (cursusId > 0) {
			UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl()).path("/cursussen/" + cursusId);
			URI uri = builder.build();
			return Response.status(201).contentLocation(uri).build();
		} else {
			return Response.status(404).build();
		}
	}

	@GET
	@Path("/{organisatieId}/opleidingsprofielen")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft een lijst met alle opleidingsprofielen binnen een organisatie.")
	public Response findOpleidingsProfielenByOrganisatie(@PathParam("organisatieId") int organisatieId) {
		if (!firebaseInit.functionInUser("organisatieopleidingsprofielen_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<OpleidingsProfielDto> list = organisatieService.findOpleidingsProfielenByOrganisatie(organisatieId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path("/{organisatieId}/opleidingsprofielen")
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Maakt een nieuw opleidingsprofiel binnen een organisatie aan.")
	public Response createOpleidingsProfielByOrganisatie(@PathParam("organisatieId") int organisatieId,
			OpleidingsProfielPostDto opleidingsProfielDto) {
		if (!firebaseInit.functionInUser("organisatieopleidingsprofiel_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		int opleidingsProfielId = organisatieService.createOpleidingsProfielByOrganisatie(organisatieId,
				opleidingsProfielDto);
		if (opleidingsProfielId > 0) {
			UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl())
					.path("opleidingsprofielen/" + opleidingsProfielId);
			URI uri = builder.build();
			return Response.status(201).contentLocation(uri).build();
		} else {
			return Response.status(404).build();
		}
	}

	@GET
	@Path("/{organisatieId}/beroepstaken")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(value = "Geeft een lijst met alle BeroepsTaken binnen een organisatie.")
	public Response findBeroepsTaakByOrganisatie(@PathParam("organisatieId") int organisatieId) {
		if (!firebaseInit.functionInUser("organisatieberoepstaken_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<BeroepsTaakDto> list = organisatieService.findBeroepsTakenByOrganisatie(organisatieId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

}
