package co.com.colt.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.com.colt.dto.UsuarioDTO;


@Path("/ColtServiceLogin")
public interface IColtLoginServices {
	/**
	 * login
	 * @param json
	 * @return
	 */	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(UsuarioDTO login);
	
}
