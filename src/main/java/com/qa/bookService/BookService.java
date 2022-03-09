package com.qa.bookService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.books.Books;
import com.qa.repo.Repo;
import com.qa.scrape.Scrape;

@Service
public class BookService {

	private Repo repo;

	@Autowired
	public BookService(Repo repo) {
		this.repo = repo;
	}

	public Books createBook(Books book) {
		return this.repo.save(book);
	}

	public List<Books> getAllBooks() {
		// SELECT * FROM books;
		return this.repo.findAll();
	}

	public Books getAll() throws IOException {
		// test version to check working
		System.out.println("returning from BookService " + Scrape.Scrape());
		return Scrape.Scrape();
	}

	// get by id
	public Books getId(Integer id) {
		Optional<Books> bookLook = this.repo.findById(id);

		if (bookLook.isPresent()) {
			return bookLook.get();
		} else {
			throw new EntityNotFoundException("book not found");
		}

	}

	// update by id
	public Books updateBooks(Integer id, Books book) {
		Books foundBooks = this.getId(id);
		foundBooks.setTitle(book.getTitle());
		foundBooks.setPrice(book.getPrice());
		foundBooks.setInStock(book.getInStock());
		return this.repo.save(foundBooks);
	}

	// Delete by id
	public boolean deleteBook(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
