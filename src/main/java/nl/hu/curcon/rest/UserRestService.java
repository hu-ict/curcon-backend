package nl.hu.curcon.rest;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.annotations.Api;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.HRefDto;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dto.post.IdPostDto;
import nl.hu.curcon.dto.post.UserPutDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Dto2DomainMapper;
import nl.hu.curcon.service.UserService;
import nl.hu.curcon.filter.FirebaseInit;

@Component
@Path("/users")
@Api(hidden = false, value = "[User] Raadplegen en wijzigen van een USER.")
public class UserRestService {
	@Autowired
	UserService userService;
	@Autowired
	FirebaseInit firebaseInit;
	@Autowired
	Domain2DtoMapper domain2DtoMapper;

	@Autowired
	Dto2DomainMapper dto2DomainMapper;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAll() {
		if (!firebaseInit.functionInUser("users_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<UserDto> list = userService.findAll();
		return Response.ok(list).build();
	}

	@GET
	@Path("/{username}")
	@Produces({ MediaType.APPLICATION_JSON })
	public UserDto find(@PathParam("username") String username) {
		if (!firebaseInit.functionInUser("user_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return userService.find(username);
	}

	@GET
	@Path("{username}/role")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findRole(@PathParam("username") String username) {
		if (!firebaseInit.functionInUser("userrole_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		RoleDto role= userService.findRoleByUser(username).get(0);
		return Response.ok(role).build();
	}

	@GET
	@Path("{username}/functions")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findFunctionsbyuser(@PathParam("username") String username) {
		if (!firebaseInit.functionInUser("userfunctions_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<FunctionDto> list = userService.findFunctionsByUsername(username);
		return Response.ok(list).build();

	}

	@DELETE
	@Path("/{username}")
	@Transactional
	public Response delete(@PathParam("username") String username) {
		if (!firebaseInit.functionInUser("user_delete")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		UserDto dto = userService.find(username);
		if (dto == null) {
			return Response.status(404).build();

		} else {
			userService.delete(dto.getUsername());
			return Response.status(200).build();
		}
	}
	@PUT
	@Path("/{username}/role")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response createCursusByOrganisatie(@PathParam("username") String username, IdPostDto dto) {
		if (!firebaseInit.functionInUser("user_put")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (userService.updateRoleByUser(username, dto.getId())) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}

}
