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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.hu.curcon.dto.CursusDto;
import nl.hu.curcon.dto.LeerdoelDto;
import nl.hu.curcon.dto.ToetsDto;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillDto;
import nl.hu.curcon.dto.post.CursusPostDto;
import nl.hu.curcon.dto.post.IdPostDto;
import nl.hu.curcon.dto.post.LeerdoelPostDto;
import nl.hu.curcon.dto.post.ToetsPostDto;
import nl.hu.curcon.service.CursusService;

/**
 * @author berend.wilkens, 16 mei 2017
 */
@Api(value = "[Cursus] Alles over cursussen en gekoppelde beroepstaken, leerdoelen en toetsen.")
@Component
@Path("/cursussen")
public class CursusRestService {
	@Autowired
	CursusService cursusService;

	private static final Logger LOG = LoggerFactory.getLogger(CursusRestService.class);

	@GET
	@Path("/{cursusId}")
	@Transactional
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft een cursus op basis van zijn id")
	public Response find(@PathParam("cursusId") int id) {
		CursusDto dto = cursusService.find(id);
		if (dto != null) {
			return Response.ok(dto).build();
		} else {
			return Response.status(404).build();
		}
	}

	@PUT
	@Path("/{cursusId}")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Doet een update op een bestaande cursus.")
	public Response update(@PathParam("cursusId") int cursusId, CursusPostDto cursusDto) {
		if (cursusService.update(cursusId, cursusDto)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
	}

	@DELETE
	@Path("/{cursusId}")
	@Transactional
	@ApiOperation(hidden = true, value = "Verwijderd een cursus met zijn leerdoelen en toetsen.")
	public Response delete(@PathParam("cursusId") int id) {
		CursusDto dto = cursusService.find(id);
		if (dto == null) {
			return Response.status(404).build();

		} else {
			cursusService.delete(dto.getId());
			return Response.status(200).build();
		}
	}

	@GET
	@Path("/{cursusId}/leerdoelen")
	@Transactional
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft alle leerdoelen bij een cursus.")
	public Response findLeerdoelenByCursus(@PathParam("cursusId") int cursusId) {
		List<LeerdoelDto> list = cursusService.getLeerdoelenByCursus(cursusId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path("/{cursusId}/leerdoelen")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Maakt een nieuw leerdoel bij een cursus.")
	public Response createLeerdoelByCursus(@PathParam("cursusId") int cursusId, LeerdoelPostDto leerdoelDto) {
		LOG.info("createLeerdoelByCursus");
		LOG.info("cursusId: " + cursusId);
		int leerdoelId = cursusService.createLeerdoelByCursus(cursusId, leerdoelDto);
		LOG.info("Nieuw leerdoelId: " + leerdoelId);
		if (leerdoelId == 0) {
			return Response.status(404).build();
		}
		UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl())
				.path("/leerdoelen/" + leerdoelId);
		URI uri = builder.build();
		return Response.status(201).contentLocation(uri).build();
	}

	@GET
	@Path("/{cursusId}/toetsen")
	@Transactional
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft alle toetsen bij een cursus.")
	public Response findToetsenByCursus(@PathParam("cursusId") int id) {
		List<ToetsDto> list = cursusService.getToetsenByCursus(id);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path("/{cursusId}/toetsen")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Maakt een toets bij een cursus.")
	public Response create(@PathParam("cursusId") int cursusId, ToetsPostDto toetsDto) {
		int toetsId = cursusService.createToetsByCursus(cursusId, toetsDto);
		if (toetsId == 0) {
			return Response.status(404).build();
		} else {
			UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl())
					.path("toetsen/" + toetsId);
			URI uri = builder.build();
			return Response.status(201).contentLocation(uri).build();
		}
	}

	@GET
	@Path("/{cursusId}/beroepstaken")
	@Transactional
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft alle beroepstaken bij een cursus.")
	public Response findBeroepsTakenByCursus(@PathParam("cursusId") int id) {
		List<BeroepsTaakDto> list = cursusService.getBeroepsTakenByCursus(id);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path("/{cursusId}/beroepstaken")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Voegt een nieuwe beroepstaak aan een cursus toe. [LINK]")
	public Response addBeroepsTaakToCursus(@PathParam("cursusId") int cursusId, IdPostDto dto) {
		if (cursusService.addBeroepsTaakToCursus(cursusId, dto.getId())) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}

	@DELETE
	@Path("/{cursusId}/beroepstaken/{beroepstaakId}")
	@Transactional
	@ApiOperation(value = "Verwijderd een beroepsTaak van een cursus. [LINK]")
	public Response removeBeroepsTaakFromCursus(@PathParam("cursusId") int cursusId,
			@PathParam("beroepstaakId") int beroepstaakId) {
		if (cursusService.removeBeroepsTaakFromCursus(cursusId, beroepstaakId)) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}

	@GET
	@Path("/{cursusId}/professionalskills")
	@Transactional
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft alle professional skill bij een cursus.")
	public Response findProfessionalSkillsByCursus(@PathParam("cursusId") int id) {
		List<ProfessionalSkillDto> list = cursusService.getProfessionalSkillsByCursus(id);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path("/{cursusId}/professionalskills")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Voegt een nieuwe professional skill aan een cursus toe. [LINK]")
	public Response addProfessionalSkillToCursus(@PathParam("cursusId") int cursusId, IdPostDto dto) {
		if (cursusService.addProfessionalSkillToCursus(cursusId, dto.getId())) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}

	@DELETE
	@Path("/{cursusId}/professionalskills/{professionalskillId}")
	@Transactional
	@ApiOperation(value = "Verwijderd een professional skill van een cursus. [LINK]")
	public Response removeProfessionalSkillFromCursus(@PathParam("cursusId") int cursusId,
			@PathParam("professionalskillId") int professionalskillId) {
		if (cursusService.removeProfessionalSkillFromCursus(cursusId, professionalskillId)) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}
	
	@GET
	@Path("/{cursusId}/checks")
	@Transactional
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft de resultaten van de check van een cursus.")
	public Response checkCursus(@PathParam("cursusId") int cursusId) {
		List<String> list = cursusService.check(cursusId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}



}
