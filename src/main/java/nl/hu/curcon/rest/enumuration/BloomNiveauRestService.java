package nl.hu.curcon.rest.enumuration;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import nl.hu.curcon.dto.BloomNiveauDto;
import nl.hu.curcon.service.BloomNiveauService;

@Component
@Path("/bloomniveaus")
@Api(hidden = false, value="[BloomNiveau] Raadplegen van de Bloomniveaus")
public class BloomNiveauRestService {
    @Autowired
    BloomNiveauService bloomNiveauService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<BloomNiveauDto> findAll() {
		return bloomNiveauService.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public BloomNiveauDto find(@PathParam("id") int id) {
		return bloomNiveauService.find(id);
	}

}
