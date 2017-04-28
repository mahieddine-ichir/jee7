package com.michir.jaxrs;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class EtudiantsRepository {

	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	@Inject
	ClasseDao classeDao;
	
	@PostConstruct
	public void init() {
		this.add(Etudiant.valueOf("Etudiant 1", 22, "Classe 1"));
		this.add(Etudiant.valueOf("Etudiant 2", 22, "Classe 2"));
		this.add(Etudiant.valueOf("Etudiant 3", 22, "Classe 3"));
		this.add(Etudiant.valueOf("Etudiant 4", 22, "Classe 2"));
		this.add(Etudiant.valueOf("Etudiant 5", 22, "Classe 1"));
		this.add(Etudiant.valueOf("Etudiant 6", 22, "Classe 1"));
	}

	public Collection<Etudiant> all() {
		return em.createQuery("FROM Etudiant", Etudiant.class).getResultList();
	}

	public Collection<Etudiant> allFetch() {
		return em.createQuery("FROM Etudiant e JOIN FETCH e.classe", Etudiant.class).getResultList();
	}

	public Collection<Etudiant> all(String name) {
		return em.createQuery("FROM Etudiant e WHERE e.nom = :name", Etudiant.class)
				.setParameter("name", name)
				.getResultList();
	}
	
	public Collection<Etudiant> allByClass(String className) {
		return em.createQuery("SELECT e FROM Etudiant e WHERE e.classe.nom = :name", Etudiant.class)
				.setParameter("name", className)
				.getResultList();
	}
	
	public Etudiant add(Etudiant etudiant) {
		
		Classe classe = etudiant.getClasse();
		Collection<Classe> byName = classeDao.byName(classe.getNom());
		if (byName == null || byName.isEmpty()) {
			em.persist(classe);
		} else {
			etudiant.setClasse(byName.iterator().next());
		}

		em.persist(etudiant);
		return etudiant;
	}
	
	public void delete(Integer id) {
		Etudiant entity = em.find(Etudiant.class, id);
		em.remove(entity);
	}
}
