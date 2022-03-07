package com.qa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.bookService.BookService;
import com.qa.books.Books;
import com.qa.scrape.Scrape;

@RestController // Tells Spring this is a Rest controller and that Spring needs to manage it
public class Controller {
	
	
	
	private BookService service;
	
	@Autowired
	public Controller(BookService service) {
		this.service = service;
	}
	
	
	// this is a placeholder for the up and coming database mapping requests
	@GetMapping("/getAll")
	public ResponseEntity<List<Books>> getAll() {
		return new ResponseEntity<List<Books>>(HttpStatus.OK);
	}
	
	// This test section outputs all the scraped data from the web site in one dump to http://localhost:8080/text
	@GetMapping("/text")
	public ArrayList<String> scrapedData(){
		return Scrape.scrapedData();
	}

}
