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
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.post.FunctionPostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Dto2DomainMapper;
import nl.hu.curcon.service.FunctionService;

@Component
@Path("/functions")
@Api(hidden = false,value="Beheren van functions")
public class FunctionRestService {
    @Autowired
    FunctionService functionService;

	@Autowired
	Domain2DtoMapper domain2DtoMapper;

	@Autowired
	Dto2DomainMapper dto2DomainMapper;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAll() {
		List<FunctionDto> list = functionService.findAll();
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/{functionId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public FunctionDto find(@PathParam("functionId") int id) {
		return functionService.find(id);
	}
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(FunctionPostDto functionDto) {
		int functionId = functionService.create(functionDto);
		if (functionId > 0) {
			UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl()).path("functions/" + functionId);
			URI uri = builder.build();
			return Response.status(201).contentLocation(uri).build();
		} else {
			return Response.status(404).build();
		}
	}

	@PUT
	@Path("/{functionId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(@PathParam("functionId") int functionId, FunctionPostDto functionDto) {
		if (functionService.update(functionId, functionDto)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
	}
	@DELETE
	@Path("/{functionId}")
	@Transactional
	public Response delete(@PathParam("functionId") int functionId) {
		FunctionDto dto = functionService.find(functionId);
		if (dto == null) {
			return Response.status(404).build();

		} else {
			functionService.delete(dto.getId());
			return Response.status(200).build();
		}
	}
}
