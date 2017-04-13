package com.michir.jee7.jpa;

import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class AuthorDao {

	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	public void save(Author a) {
		Logger.getLogger("AuthorDao").info("saving author "+a);
		Author find = em.find(Author.class, a.getId());
		if (find == null) {
			em.persist(a);
		} else {
			a = em.merge(a);
		}
	}
}
