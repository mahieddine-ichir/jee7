package com.michir.jaxrs;

import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EtudiantsDao {

	private static Collection<Etudiant> etudiants;
	static {
		etudiants = new ArrayList<>();
		
		etudiants.add(Etudiant.valueOf("Etudiant 1", 22, "Classe 1"));
		etudiants.add(Etudiant.valueOf("Etudiant 2", 21, "Classe 2"));
		etudiants.add(Etudiant.valueOf("Etudiant 3", 21, "Classe 3"));
		etudiants.add(Etudiant.valueOf("Etudiant 4", 19, "Classe 1"));
		etudiants.add(Etudiant.valueOf("Etudiant 5", 22, "Classe 1"));
	}
	
	public Collection<Etudiant> all() {
		return etudiants;
	}
	
}
