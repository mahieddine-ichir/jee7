package com.michir.jee7.jpa;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="BOOKS")
public class Book {

	@ManyToOne
	@NotNull // FIXME
	private Author author;

	@EmbeddedId
	private BookId bookId;

	private Date creationDate = Calendar.getInstance().getTime();
	
	/**
	 * @return the author
	 */
	public final Author getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public final void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * @return the bookId
	 */
	public final BookId getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public final void setBookId(BookId bookId) {
		this.bookId = bookId;
	}
	

	@Override
	public String toString() {
		return super.toString()+", isbn "+bookId.getIsbn()+", title "+bookId.getTitle();
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
