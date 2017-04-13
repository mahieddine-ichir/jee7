package com.michir.jee7.jpa;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookApi {

	@Inject
	BookDao bookDao;
	
	@Inject
	AuthorDao authorDao;
	
	@GET
	public Collection<Book> books() {
		return bookDao.books();
	}

	@GET
	@Path("/mock")
	public String save() {

		BookId bookId = new BookId();
		Author aut = new Author();
		Book book = new Book();
		AuthorId author = new AuthorId();
		
		double random = Math.random();
		if (random < 0.333) {
		
			author.setLastName("any-author");
			author.setName("any-author");
			
			bookId.setIsbn(UUID.randomUUID().toString());
			bookId.setTitle("book "+UUID.randomUUID().toString().substring(10, 16));
		
		} else if (random >= 0.33 && random < .66) {

			author.setLastName("ichir");
			author.setName("mahieddine");

			bookId.setIsbn("isbn-1236548979");
			bookId.setTitle("reference");
		} else {

			author.setLastName("ichir");
			author.setName("rafika");
			
			bookId.setIsbn("isbn-1236548XXX");
			bookId.setTitle("reference");

		}

		aut.setId(author);
		book.setAuthor(aut);
		book.setBookId(bookId);
		
		return this.save(book);
	}
	
	@POST
	public String save(Book book) {
		authorDao.save(book.getAuthor());
		bookDao.save(book);
		return book.getBookId().getIsbn();
	}
}
