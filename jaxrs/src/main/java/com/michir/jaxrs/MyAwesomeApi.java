package com.michir.jaxrs;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/etudiants")
@Produces(MediaType.APPLICATION_JSON)
public class MyAwesomeApi {

	@Inject
	private EtudiantsDao backend;
	
	@GET
	public Collection<Etudiant> etudiants() {
		return backend.all();
	}
	
	@DELETE
	public void delete(Integer id) {
		backend.delete(id);
	}
	
}
