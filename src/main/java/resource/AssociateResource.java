package resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Associate;
import service.AssociateService;

@Path("associate")
public class AssociateResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Response getAllAssociates() {
				
		List<Associate>  associates= AssociateService.getAllAssociates();
		
		return Response.ok(associates,MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public static Response deleteAssociate(Associate associate) {
		
		AssociateService.deleteAssociate(associate);	
		return Response.ok().build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public static Response createAssociate(Associate associate) {
		
		AssociateService.createAssociate(associate);
		
		return Response.ok().build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public static Response updateAssociate(Associate associate) {
		
		AssociateService.updateAssociate(associate);
		
		return Response.ok().build();
	}
}
