package com.michir.jaxrs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="etudiants_history")
public class EtudiantHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="modification_date")
	private Date modifictionDate;
	
	@Column(name="deletion_date")
	private Date deletionDate;
	
	@Column(name="etudiant_name")
	private String etudiantName;

	@Column(name="etudiant_id")
	private Long etudiantId;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the modifictionDate
	 */
	public Date getModifictionDate() {
		return modifictionDate;
	}

	/**
	 * @param modifictionDate the modifictionDate to set
	 */
	public void setModifictionDate(Date modifictionDate) {
		this.modifictionDate = modifictionDate;
	}

	/**
	 * @return the deletionDate
	 */
	public Date getDeletionDate() {
		return deletionDate;
	}

	/**
	 * @param deletionDate the deletionDate to set
	 */
	public void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}

	/**
	 * @return the etudiantName
	 */
	public String getEtudiantName() {
		return etudiantName;
	}

	/**
	 * @param etudiantName the etudiantName to set
	 */
	public void setEtudiantName(String etudiantName) {
		this.etudiantName = etudiantName;
	}

	/**
	 * @return the etudiantId
	 */
	public Long getEtudiantId() {
		return etudiantId;
	}

	/**
	 * @param etudiantId the etudiantId to set
	 */
	public void setEtudiantId(Long etudiantId) {
		this.etudiantId = etudiantId;
	}

	
	
}
