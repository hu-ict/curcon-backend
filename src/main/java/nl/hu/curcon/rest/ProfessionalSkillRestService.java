package nl.hu.curcon.rest;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import nl.hu.curcon.dto.competence.ProfessionalSkillDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillTypesDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Dto2DomainMapper;
import nl.hu.curcon.service.ProfessionalSkillService;
import nl.hu.curcon.filter.FirebaseInit;

@Component
@Path("/professionalskills")
@Api(hidden = false)
public class ProfessionalSkillRestService {
	@Autowired
	ProfessionalSkillService professionalSkillService;
	@Autowired
	FirebaseInit firebaseInit;
	@Autowired
	Domain2DtoMapper domain2DtoMapper;

	@Autowired
	Dto2DomainMapper dto2DomainMapper;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ProfessionalSkillDto> findAll() {
		if (!firebaseInit.functionInUser("professionals_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		return professionalSkillService.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public ProfessionalSkillDto find(@PathParam("id") int id) {
		if (!firebaseInit.functionInUser("professional_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		return professionalSkillService.find(id);
	}

 	@GET
 	@Path("/types")
	@Produces({ MediaType.APPLICATION_JSON })
	public ProfessionalSkillTypesDto findTypes() {
		if (!firebaseInit.functionInUser("professionaltypes_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		return professionalSkillService.findTypes();
	}

	@GET
	@Path("/skill/{skillId}/niveaus/{niveau}")
	@Produces({ MediaType.APPLICATION_JSON })
	public ProfessionalSkillDto find(@PathParam("skillId") int skillId, @PathParam("niveau") String niveau) {
		if (!firebaseInit.functionInUser("professional_find")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		return professionalSkillService.find(skillId, niveau);
	}


}
