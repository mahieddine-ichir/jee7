package com.michir.jee7.jpa;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class BookDao {

	//@PersistenceUnit(??) // EntityManagerFactory
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	public Collection<Book> books() {
		return em.createQuery("FROM Book", Book.class).getResultList();
	}

	public void save(Book b) {
		Book find = em.find(Book.class, b.getBookId());
		if (find == null) {
			em.persist(b);
		} else {
			b.setAuthor(find.getAuthor());
			b = em.merge(b);
		}
	}

	public void delete(Book b) {
		em.remove(b);
	}
	
}
