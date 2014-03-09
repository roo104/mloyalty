package dk.unwire.fym.mloyalty.rest;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.util.HttpResponseCodes;

import dk.unwire.fym.mloyalty.dao.UserDao;
import dk.unwire.fym.mloyalty.model.User;
import dk.unwire.fym.mloyalty.rest.security.Roles;

@Path("/")
public class UserRest {
	
	@Inject
	private UserDao userDao;

	@RolesAllowed(Roles.END_USER)
	@GET
	@Path("user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBalance(@PathParam("userId") long userId) {
		User user = userDao.getUserById(userId);
		return Response.status(HttpResponseCodes.SC_OK).entity(user).build();
	}
}
