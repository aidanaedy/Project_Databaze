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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.bookService.BookService;
import com.qa.books.Books;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data

// __________________________________________________________________________

// ___________This is a Rest controller and Spring needs to manage it____________
@RestController 
public class Controller {

	private BookService service;

	@Autowired
	public Controller(BookService service) {
		this.service = service;
	}

	

	// __________________________________________________________________________

	// _______________________________Create____________________________________
	
	@PostMapping("/create")
	public ResponseEntity<Books> createBook(@RequestBody Books book) {
		return new ResponseEntity<Books>(this.service.createBook(book), HttpStatus.CREATED);
	}

	
	// __________________________________________________________________________

	// _____________________________Delete By id_________________________________
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteByIndex(@PathVariable Integer id) {
		boolean hasDeleted = this.service.deleteBook(id);
		if (hasDeleted) {
			return new ResponseEntity<Boolean>(hasDeleted, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Boolean>(hasDeleted, HttpStatus.NOT_IMPLEMENTED);
		}
	}


	
	
	// __________________________________________________________________________

	// ____________________________Get All The Books_____________________________
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Books>> getAllBooks() {
		return new ResponseEntity<List<Books>>(this.service.getAllBooks(), HttpStatus.OK);
	}

	
	
	// __________________________________________________________________________

	// ___________________Retrieve A Book By The ID (Index)_______________________

	@GetMapping("/getByIndex/{id}")
	public ResponseEntity<Books> getByIndex(@PathVariable Integer id) {
		return new ResponseEntity<Books>(this.service.getId(id), HttpStatus.OK);
	}


	
	// __________________________________________________________________________

	// _________________Update  A Books Details By The ID (Index)__________________

	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Books> updateBooks(@PathVariable Integer id, @RequestBody Books book) {
		return new ResponseEntity<Books>(this.service.updateBooks(id, book), HttpStatus.ACCEPTED);

	}
	
	
	// __________________________________________________________________________

	// ________A Default Landing Page Which Also Helps To Create A Test___________
	
	@RequestMapping("/")
    public String landingPage() {
        return "Welcome to the landing page, please select either /create, /delete(id), /getAllBooks, /getByIndex/(id), or /updateBook/(id)";
    }
	
	// __________________________________________________________________________

	// ______A Trial End Point For Adding The Internet Data To The Data Base_______
	
	@RequestMapping("/loaded")
    public String loadingPage() {
        return " test ";
    }

}
