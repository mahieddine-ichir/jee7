package com.michir.jee7.jpa;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="AUTHORS")
public class Author {

	private Date creationDate = Calendar.getInstance().getTime();
	
	@EmbeddedId
	private AuthorId id;

	/**
	 * @return the id
	 */
	public final AuthorId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(AuthorId id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return super.toString()+", author "+id;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
