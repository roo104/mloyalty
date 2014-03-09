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

import dk.unwire.fym.mloyalty.model.Balance;
import dk.unwire.fym.mloyalty.rest.security.Roles;
import dk.unwire.fym.mloyalty.service.BalanceService;

@Path("/")
public class BalanceRest {

	@Inject
	private BalanceService balanceService;

	@RolesAllowed(Roles.END_USER)
	@GET
	@Path("balance/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBalance(@PathParam("userId") long userId) {
		Balance balance = this.balanceService.getUserBalance(userId);
		return Response.status(HttpResponseCodes.SC_OK).entity(balance).build();
	}
}
