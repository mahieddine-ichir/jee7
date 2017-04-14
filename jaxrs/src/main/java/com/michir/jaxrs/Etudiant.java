package com.michir.jaxrs;

public class Etudiant {

	private String nom;
	
	private Integer age;
	
	private String classe;

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
	public String getClasse() {
		return classe;
	}

	/**
	 * @param classe the classe to set
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	static Etudiant valueOf(String nom, Integer age, String classe) {
		Etudiant etudiant = new Etudiant();
		etudiant.setNom(nom);
		etudiant.setAge(age);
		etudiant.setClasse(classe);
		return etudiant;
	}
	
}
