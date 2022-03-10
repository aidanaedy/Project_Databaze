/**---------------------------------------------------------------------------------------------
 * @author aidan
 *                        Test file for the controller section and it's components
 ____________________________________________________________________________*/
package com.qa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

	
	
	/******************************************************************************
	 *                                               Test method for 
	 *                                                  CreateBook
	 */
	@Test
	void testCreateBook() throws Exception {

		// Given
		Books newBook = new Books("Ready player one", 12, 9.95, true);
		String newBookJSON = this.mapper.writeValueAsString(newBook);

		Books savedBook = new Books("Ready player one", 12, 9.95, true);
		String savedBookJSON = this.mapper.writeValueAsString(savedBook);
		// When
		RequestBuilder request = post("/create").contentType
				(MediaType.APPLICATION_JSON).content(newBookJSON);

		ResultMatcher responseStatus = status().isCreated();
		ResultMatcher responseContent = content().json(savedBookJSON);
		// Then
		this.mvc.perform(request).andExpect(responseStatus).andExpect(responseContent);
	}

	
	
	
	/******************************************************************************
	 *                                               Test method for 
	 *                                                DeleteByIndex
	 */
	@Test
	void testDeleteByIndex() throws Exception {
		this.mvc.perform(delete("/delete/9")).andExpect(status().isAccepted());
	}

	
	
	
	/******************************************************************************
	 *                                               Test method for 
	 *                                                  GetAllBooks 
	 */
	@Test
	void testGetAllBooks() throws Exception {
		// Given
		List<Books> book = new ArrayList<>();
		book.add(new Books("The good, the bad and the ugly", 5, 15.99, true));
		book.add(new Books("For a few dollars more", 6, 19.99, true));
		book.add(new Books("Fist full of travellers cheques", 7, 21.99, false));
		book.add(new Books("5 go mad in Dorset", 8, 10.99, true));
		book.add(new Books("Bad news", 9, 17.99, true));

		String savedBookJSON = this.mapper.writeValueAsString(book);
		// When
		RequestBuilder request = get("/getAllBooks");

		ResultMatcher responseStatus = status().isOk();
		ResultMatcher responseContent = content().json(savedBookJSON);
		// Then
		this.mvc.perform(request).andExpect(responseStatus).andExpect(responseContent);
	}

	
	
	/******************************************************************************
	 *                                               Test method for 
	 *                                                  GetByIndex 
	 */
	@Test
	void testGetByIndex() throws Exception {
		// Given
		Books savedBook = new Books("Bad news", 9, 17.99, true);
		String savedBookJSON = this.mapper.writeValueAsString(savedBook);
		// When
		RequestBuilder req = get("/getByIndex/9");

		ResultMatcher responseStatus = status().isOk();
		ResultMatcher responseContent = content().json(savedBookJSON);
		// Then
		this.mvc.perform(req).andExpect(responseStatus).andExpect(responseContent);
	}

	
	
	/******************************************************************************
	 *                                               Test method for 
	 *                                                 updateBooks 
	 */
	@Test
	void testUpdateBooks() throws Exception {
		// Given
		Books updatedBook = new Books("Ready player one", 9.98, true);
		String updatedBookJSON = this.mapper.writeValueAsString(updatedBook);

		Books matchedBook = new Books("Ready player one", 9, 9.98, true);
		String matchedBookJSON = this.mapper.writeValueAsString(matchedBook);
		// When
		RequestBuilder req = put("/updateBook/9").contentType
				(MediaType.APPLICATION_JSON).content(updatedBookJSON);

		ResultMatcher responseStatus = status().isAccepted();
		ResultMatcher responseContent = content().json(matchedBookJSON);
		// Then
		this.mvc.perform(req).andExpect(responseStatus).andExpect(responseContent);
	}

}
