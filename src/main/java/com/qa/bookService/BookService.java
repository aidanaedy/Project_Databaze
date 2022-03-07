package com.qa.bookService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
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
	
	public Books createPerson(Books b) {
		return this.repo.save(b);
	}
	
	
//	public List<Books> getAllBooks() {
//		// SELECT * FROM books;
//		return this.repo.findAll();
//	}
	
	public ArrayList<String> getAll() throws IOException {
		// SELECT * FROM books;
		//return this.repo.findAll();
		System.out.println("returning from BookService " + Scrape.Scrape());
		return Scrape.Scrape();
	}


}
