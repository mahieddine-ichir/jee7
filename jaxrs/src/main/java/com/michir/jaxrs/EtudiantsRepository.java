package com.michir.jaxrs;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class EtudiantsRepository {

	private Collection<Etudiant> etudiants;
	
	@PostConstruct
	public void init() {
		etudiants = new ArrayList<>();
		this.add(Etudiant.valueOf("Etudiant 1", 22, "Classe 1"));
		this.add(Etudiant.valueOf("Etudiant 2", 22, "Classe 2"));
		this.add(Etudiant.valueOf("Etudiant 3", 22, "Classe 3"));
		this.add(Etudiant.valueOf("Etudiant 4", 22, "Classe 2"));
		this.add(Etudiant.valueOf("Etudiant 5", 22, "Classe 1"));
		this.add(Etudiant.valueOf("Etudiant 6", 22, "Classe 1"));
	}

	public Collection<Etudiant> all() {
		return etudiants;
	}
	
	public Etudiant add(Etudiant etudiant) {
		etudiants.add(etudiant);
		etudiant.setId(etudiants.size());
		return etudiant;
	}
	
	public void delete(Integer id) {
		Etudiant etudiant = etudiants.stream().filter(e -> e.getId().intValue() == id.intValue()).findFirst().get();
		etudiants.remove(etudiant);
	}
}
