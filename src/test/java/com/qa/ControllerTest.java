/**----------------------------------------------------------------------------------------------------------------------
 * @author aidan
 *                                              Test file for the controller section and it's components
 __________________________________________________________________________________________________*/
package com.qa;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.books.Books;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = { "classpath:book-schema.sql",
		"classpath:book-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc

public class ControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void testSetUpBeforeClass() throws Exception {
		System.out.println("This should be printed before the class");
	}

	/******************************************
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void testSetUp() throws Exception {
	}

	/*****************************************************************************
	 * Test method for
	 * {@link com.qa.controller.Controller#Controller(com.qa.bookService.BookService)}.
	 */
	@Test
	final void testController() {

		System.out.println("This should be printed when the controller is running");
	}

	
	
	/******************************************
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void testSetUpCreateBook() throws Exception {
	}
	/*****************************************************************************
	 * Test method for
	 * {@link com.qa.controller.Controller#createBook(com.qa.books.Books)}.
	 */
	@Test
	final void testCreateBook() throws Exception {

		// Given
		Books newBook = new Books("Ready player one", 12, 9.95, true);
		String newBookJSON = this.mapper.writeValueAsString(newBook);

		Books savedBook = new Books("Ready player one", 12, 9.95, true);
		String savedBookJSON = this.mapper.writeValueAsString(savedBook);
		// When
		RequestBuilder request = post("/create").contentType(MediaType.APPLICATION_JSON).content(newBookJSON);

		ResultMatcher responseStatus = status().isCreated();
		ResultMatcher responseContent = content().json(savedBookJSON);
		// Then
		this.mvc.perform(request).andExpect(responseStatus).andExpect(responseContent);
	}
	
	/*****************************************
	 * Test method for after the create section
	 * {@link com.qa.controller.Controller#Controller(com.qa.bookService.BookService)}.
	 */
	@Test
	final void postCreateTest() {

		System.out.println("This should be outputted after the create section has run");
	}
	
	
	/******************************************
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void testSetUpDeleteByIndex() throws Exception {
	}

	/*****************************************************************************
	 * Test method for
	 * {@link com.qa.controller.Controller#deleteByIndex(java.lang.Integer)}.
	 */
	@Test
	final void testDeleteByIndex() throws Exception {
		this.mvc.perform(delete("/delete/199")).andExpect(status().isAccepted());
	}
	
	/*****************************************
	 * Test method for after the delete section
	 * {@link com.qa.controller.Controller#Controller(com.qa.bookService.BookService)}.
	 */
	@Test
	final void postDeleteTest() {

		System.out.println("This should be outputted after the delete section has run");
	}

	/******************************************
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void testSetUpGetAllBooks() throws Exception {
	}

	/******************************************************************************
	 * Test method for {@link com.qa.controller.Controller#getAllBooks()}.
	 */
	@Test
	final void testGetAllBooks() throws Exception {
		List<Books> book = new ArrayList<>();
		book.add(new Books("The good, the bad and the ugly", 5, 15.99, true));
		book.add(new Books("For a few dollars more", 6, 19.99, true));
		book.add(new Books("Fist full of travellers cheques", 7, 21.99, false));
		book.add(new Books("5 go mad in Dorset", 8, 10.99, true));
		book.add(new Books("Bad news", 9, 17.99, true));

		String savedBookJSON = this.mapper.writeValueAsString(book);

		RequestBuilder req = get("/getAllBooks");

		ResultMatcher responseStatus = status().isOk();
		ResultMatcher responseContent = content().json(savedBookJSON);

		this.mvc.perform(req).andExpect(responseStatus).andExpect(responseContent);
	}

	
	/*****************************************
	 * Test method for after the getAllBooks section
	 * {@link com.qa.controller.Controller#Controller(com.qa.bookService.BookService)}.
	 */
	@Test
	final void testPostGetAllBooks() {

		System.out.println("This should be outputted after the getAllBooks section has run");
	}

	/******************************************
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void testSetUpGetByIndex() throws Exception {
	}
	
	/*****************************************************************************
	 * Test method for
	 * {@link com.qa.controller.Controller#getByIndex(java.lang.Integer)}.
	 */
	@Test
	final void testGetByIndex() throws Exception {
		Books savedBook = new Books("Ready player one", 12, 9.97, true);
		String savedBookJSON = this.mapper.writeValueAsString(savedBook);

		RequestBuilder req = get("/getByIndex/6");

		ResultMatcher responseStatus = status().isOk();
		ResultMatcher responseContent = content().json(savedBookJSON);

		this.mvc.perform(req).andExpect(responseStatus).andExpect(responseContent);
	}
	
	
	/*****************************************
	 * Test method for after the testGetByIndex section
	 * {@link com.qa.controller.Controller#Controller(com.qa.bookService.BookService)}.
	 */
	@Test
	final void testPostGetByIndex() {

		System.out.println("This should be outputted after the testGetByIndex section has run");
	}
	

	/******************************************
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void testSetUpUpdateBooks() throws Exception {
	}
	
	/*****************************************************************************
	 * Test method for
	 * {@link com.qa.controller.Controller#updateBooks(java.lang.Integer, com.qa.books.Books)}.
	 */
	@Test
	final void testUpdateBooks() throws Exception {
		Books updatedBook = new Books("Ready player one", 12, 9.98, true);
		String updatedBookJSON = this.mapper.writeValueAsString(updatedBook);

		RequestBuilder req = put("/updateBook/7").contentType(MediaType.APPLICATION_JSON).content(updatedBookJSON);

		ResultMatcher responseStatus = status().isAccepted();
		ResultMatcher responseContent = content().json(updatedBookJSON);

		this.mvc.perform(req).andExpect(responseStatus).andExpect(responseContent);
	}
	
	
	/*****************************************
	 * Test method for after the testUpdateBooks section
	 * {@link com.qa.controller.Controller#Controller(com.qa.bookService.BookService)}.
	 */
	@Test
	final void testPostUpdateBooks() {

		System.out.println("This should be outputted after the testUpdateBooks section has run");
	}
	
	/******************************************
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void testSetUpScrapedData() throws Exception {
	}

	/*****************************************************************************
	 * Test method for {@link com.qa.controller.Controller#scrapedData()}.
	 */
	@Test
	final void testScrapedData() {
		fail("Not yet implemented");
	}


	/*****************************************
	 * Test method for after the testUpdateBooks section
	 * {@link com.qa.controller.Controller#Controller(com.qa.bookService.BookService)}.
	 */
	@Test
	final void testPostScrapedData() {

		System.out.println("This should be outputted after the testScrapedData section has run");
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
				System.out.println("This should be outputted after everything in the section has run");
		}

}
