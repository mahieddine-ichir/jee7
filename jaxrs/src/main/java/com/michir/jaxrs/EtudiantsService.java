package com.michir.jaxrs;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;


@Stateless
public class EtudiantsService {

	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@Inject
	private EtudiantsRepository repo;
	
	@Inject
	ClasseDao classDao;
	
	public Collection<Etudiant> all() {
//		Collection<Etudiant> all = repo.all();
//		for (Etudiant e : all) {
//			Classe classe = e.getClasse();
//			System.out.println(classe.getNom());
//		}
//		return all;
		return repo.allFetch();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Etudiant add(@NotNull String nom, Integer age, String classe) {
		repo.delete(null);
		return repo.add(Etudiant.valueOf(nom, age, classe));
	}
	
	public void delete(Integer id) {
		repo.delete(id);
	}

	public Etudiant update(Etudiant e) {
		e = em.merge(e);
		return e;
	}
}
