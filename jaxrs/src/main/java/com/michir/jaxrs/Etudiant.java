package com.michir.jaxrs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="etudiants")
public class Etudiant {

	@Column(name="et_nom")
	private String nom;
	
	@Column(name="et_age")
	private Integer age;

//	@ManyToMany
//	@OneToMany(fetch=FetchType.LAZY)
//	private Collection<Cours> cours;

	@ManyToOne(fetch=FetchType.EAGER)
	private Classe classe;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	
	
	/**
	 * @return the classe
	 */
	public Classe getClasse() {
		return classe;
	}

	/**
	 * @param classe the classe to set
	 */
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	static Etudiant valueOf(String nom, Integer age, String classe) {
		Etudiant etudiant = new Etudiant();
		etudiant.setNom(nom);
		etudiant.setAge(age);
		
		Classe classe2 = new Classe();
		classe2.setNom(classe);
		etudiant.setClasse(classe2);
		return etudiant;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	};
}
