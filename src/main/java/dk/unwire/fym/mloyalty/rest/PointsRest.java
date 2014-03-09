package dk.unwire.fym.mloyalty.rest;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.util.HttpResponseCodes;

import dk.unwire.fym.mloyalty.model.Balance;
import dk.unwire.fym.mloyalty.service.BalanceService;
import dk.unwire.fym.mloyalty.service.PointService;

@Path("/")
public class PointsRest {

	@Inject
	private PointService pointService;
	@Inject
	private BalanceService balanceService;

	@PermitAll
	@GET
	@Path("points/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBalance(@PathParam("userId") long userId) {
		Balance balance = this.balanceService.getUserBalance(userId);
		return Response.status(HttpResponseCodes.SC_OK).entity(balance).build();
	}

	@RolesAllowed("MERCHANT")
	@PUT
	@Path("points/{userId}/{points}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPoints(@PathParam("userId") long userId, @PathParam("points") long points) {
		this.pointService.addPoints(userId, points);
		return Response.status(HttpResponseCodes.SC_OK).entity(null).build();
	}

}
