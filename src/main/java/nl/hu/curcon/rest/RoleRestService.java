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
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dto.post.IdPostDto;
import nl.hu.curcon.dto.post.RolePutDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Dto2DomainMapper;
import nl.hu.curcon.service.RoleService;
import nl.hu.curcon.filter.FirebaseInit;

@Component
@Path("/roles")
@Api(hidden = false, value = "Beheren van Rollen")
public class RoleRestService {
	@Autowired
	RoleService roleService;

	@Autowired
	FirebaseInit firebaseInit;
	
	@Autowired
	Domain2DtoMapper domain2DtoMapper;

	@Autowired
	Dto2DomainMapper dto2DomainMapper;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAll() {
		if (!firebaseInit.functionInUser("roles_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		List<RoleDto> list = roleService.findAll();
		return Response.ok(list).build();
	}

	@GET
	@Path("/{roleId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public RoleDto find(@PathParam("roleId") int id) {
		if (!firebaseInit.functionInUser("role_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return roleService.find(id);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(RolePutDto roleDto) {
		if (!firebaseInit.functionInUser("role_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		int roleId = roleService.create(roleDto);
		if (roleId > 0) {
			UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl()).path("roles/" + roleId);
			URI uri = builder.build();
			return Response.status(201).contentLocation(uri).build();
		} else {
			return Response.status(404).build();
		}
	}

	@PUT
	@Path("/{roleId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(@PathParam("roleId") int roleId, RolePutDto roleDto) {
		if (!firebaseInit.functionInUser("role_put")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (roleService.update(roleId, roleDto)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
	}
	@DELETE
	@Path("/{roleId}")
	@Transactional
	public Response delete(@PathParam("roleId") int roleId) {
		if (!firebaseInit.functionInUser("role_delete")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		RoleDto dto = roleService.find(roleId);
		if (dto == null) {
			return Response.status(404).build();

		} else {
			roleService.delete(dto.getId());
			return Response.status(200).build();
		}
	}
	@GET
	@Path("/{roleId}/modules")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findModulesByRole(@PathParam("roleId") int id) {
		if (!firebaseInit.functionInUser("rolemodules_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<ModuleDto> list = roleService.findModulesByRoleId(id);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path("/{roleId}/modules")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Transactional
	public Response createModuleByRole(@PathParam("roleId") int roleId, IdPostDto dto) {
		if (!firebaseInit.functionInUser("rolemodule_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (roleService.addModuleToRole(roleId, dto.getId())) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}
	
	@DELETE
	@Path("/{roleId}/{moduleId}")
	@Transactional
	@ApiOperation(value = "Verwijderd een module van een rol. [LINK]")
	public Response removeRolFromModule(@PathParam("roleId") int roleId,
			@PathParam("moduleId") int moduleId) {
		if (!firebaseInit.functionInUser("rolemodule_delete")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (roleService.removeModuleFromRole(roleId, moduleId)) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}

}
