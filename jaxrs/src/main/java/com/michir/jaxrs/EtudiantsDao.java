package com.michir.jaxrs;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;


@Stateless
public class EtudiantsDao {

	@Inject
	private EtudiantsRepository repo;
	
	public Collection<Etudiant> all() {
		return repo.all();
	}
	
	public Etudiant add(@NotNull String nom, Integer age, String classe) {
		return repo.add(Etudiant.valueOf(nom, age, classe));
	}
	
	public void delete(Integer id) {
		repo.delete(id);
	}
	
}
