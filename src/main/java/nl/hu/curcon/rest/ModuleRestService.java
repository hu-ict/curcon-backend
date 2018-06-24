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
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.post.IdPostDto;
import nl.hu.curcon.dto.post.ModulePostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Dto2DomainMapper;
import nl.hu.curcon.service.ModuleService;
import nl.hu.curcon.filter.FirebaseInit;

@Component
@Path("/modules")
@Api(hidden = false,value="Beheren van modules")
public class ModuleRestService {
	@Autowired
	ModuleService moduleService;
	
	@Autowired
	FirebaseInit firebaseInit;

	@Autowired
	Domain2DtoMapper domain2DtoMapper;

	@Autowired
	Dto2DomainMapper dto2DomainMapper;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAll() {
		if (!firebaseInit.functionInUser("modules_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		List<ModuleDto> list = moduleService.findAll();
		return Response.ok(list).build();
	}

	@GET
	@Path("/{moduleId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public ModuleDto find(@PathParam("moduleId") int id) {
		if (!firebaseInit.functionInUser("module_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return moduleService.find(id);
	}
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(ModulePostDto moduleDto) {
		if (!firebaseInit.functionInUser("module_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		int moduleId = moduleService.create(moduleDto);
		if (moduleId > 0) {
			UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl()).path("modules/" + moduleId);
			URI uri = builder.build();
			return Response.status(201).contentLocation(uri).build();
		} else {
			return Response.status(404).build();
		}
	}

	@PUT
	@Path("/{moduleId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(@PathParam("moduleId") int moduleId, ModulePostDto moduleDto) {
		if (!firebaseInit.functionInUser("module_put")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (moduleService.update(moduleId, moduleDto)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
	}
	@DELETE
	@Path("/{moduleId}")
	@Transactional
	public Response delete(@PathParam("moduleId") int moduleId) {
		if (!firebaseInit.functionInUser("module_delete")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		ModuleDto dto = moduleService.find(moduleId);
		if (dto == null) {
			return Response.status(404).build();

		} else {
			moduleService.delete(dto.getId());
			return Response.status(200).build();
		}
	}
	
	@GET
	@Path("/{moduleId}/functions")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findOpleidingsProfielenByOrganisatie(@PathParam("moduleId") int id) {
		if (!firebaseInit.functionInUser("modulefunctions_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<FunctionDto> list = moduleService.findFunctionsByModuleId(id);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}
	@POST
	@Path("/{moduleId}/functions")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Transactional
	public Response createFunctionByModule(@PathParam("moduleId") int moduleId,
			IdPostDto dto) {
		if (!firebaseInit.functionInUser("modulefunction_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (moduleService.addFunctionToModule(moduleId, dto.getId())) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}
	@DELETE
	@Path("/{moduleId}/{functionId}")
	@Transactional
	@ApiOperation(value = "Verwijderd een functie van een module. [LINK]")
	public Response removeFunctionFromModule(@PathParam("moduleId") int moduleId,
			@PathParam("functionId") int functionId) {
		if (!firebaseInit.functionInUser("modulefunction_delete")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (moduleService.removeFunctionFromModule(moduleId, functionId)) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}

}
