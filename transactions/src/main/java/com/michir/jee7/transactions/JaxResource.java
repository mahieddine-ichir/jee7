package com.michir.jee7.transactions;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class JaxResource {

	@Inject
	private BackendResource backend;

	@GET
	public Response get() throws Throwable {
		Object entity = backend.get();
		return Response.ok(entity).build();
	}
	
}
