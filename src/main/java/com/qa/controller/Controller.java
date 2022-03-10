package com.qa.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.bookService.BookService;
import com.qa.books.Books;

@RestController // This is a Rest controller and Spring needs to manage it
public class Controller {

	private BookService service;

	@Autowired
	public Controller(BookService service) {
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Books> createBook(@RequestBody Books book) {
		return new ResponseEntity<Books>(this.service.createBook(book), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteByIndex(@PathVariable Integer id) {
		boolean hasDeleted = this.service.deleteBook(id);
		if (hasDeleted) {
			return new ResponseEntity<Boolean>(hasDeleted, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Boolean>(hasDeleted, HttpStatus.NOT_IMPLEMENTED);
		}
	}

	// get all the books
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Books>> getAllBooks() {
		return new ResponseEntity<List<Books>>(this.service.getAllBooks(), HttpStatus.OK);
	}

	// get a book by the index
	@GetMapping("/getByIndex/{id}")
	public ResponseEntity<Books> getByIndex(@PathVariable Integer id) {
		return new ResponseEntity<Books>(this.service.getId(id), HttpStatus.OK);
	}

	// update a book details
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Books> updateBooks(@PathVariable Integer id, @RequestBody Books book) {
		return new ResponseEntity<Books>(this.service.updateBooks(id, book), HttpStatus.ACCEPTED);

	}

	// This test section outputs all the scraped data from the web site in one dump
	// to http://localhost:8080/text
	@GetMapping("/text")
	public Books scrapedData() throws IOException {
		// return Scrape.Scrape()
		return scrapedData();
	}

}
