package com.michir.jaxrs;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClasseDao {

	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	public Collection<Classe> all() {
		return em.createQuery("SELECT DISTINCT c FROM Classe c", Classe.class).getResultList();
	}
	
	public Collection<Classe> byName(String name) {
		return em.createQuery("FROM Classe c WHERE c.nom = :name", Classe.class)
				.setParameter("name", name)
				.getResultList();
	}
	
}
