package com.michir.jaxrs;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/classes")
@Produces(MediaType.APPLICATION_JSON)
public class ClassesApi {

	@Inject
	private ClasseDao backend;
	
	@GET
	public Collection<Classe> etudiants() {
		return backend.all();
	}
}
