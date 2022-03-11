/**---------------------------------------------------------------------------------------------
 * @author aidan
 *                        Test file for the controller section and it's components
 ____________________________________________________________________________*/
package com.qa.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

import lombok.Data;

@Data

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = { "classpath:book-schema.sql",
		"classpath:book-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
public class ControllerTest {
	
	@Test
	void Loads() {
	}

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;


	// __________________________________________________________________________

	// ______________________Test method for CreateBook_________________________
	
	@Test
	void testCreateBook() throws Exception {

		// _______________________________Given___________________________________
		Books newBook = new Books("Ready player one", 12, 9.95, true);
		String newBookJSON = this.mapper.writeValueAsString(newBook);
		Books savedBook = new Books("Ready player one", 12, 9.95, true);
		String savedBookJSON = this.mapper.writeValueAsString(savedBook);
		
		// _______________________________When___________________________________
		RequestBuilder request = post("/create").contentType(MediaType.APPLICATION_JSON).content(newBookJSON);
		ResultMatcher responseStatus = status().isCreated();
		ResultMatcher responseContent = content().json(savedBookJSON);
		
		// _______________________________Then___________________________________
		this.mvc.perform(request).andExpect(responseStatus).andExpect(responseContent);
	}


	
	
	
	// __________________________________________________________________________

	// _____________________Test method for DeleteByIndex_______________________
	
	@Test
	void testDeleteByIndex() throws Exception {
		this.mvc.perform(delete("/delete/9")).andExpect(status().isAccepted());
	}
	
	
	


	// __________________________________________________________________________

	// ______________________Test method for GetAllBooks________________________
	
	@Test
	void testGetAllBooks() throws Exception {
		
		// _______________________________Given___________________________________
		List<Books> book = new ArrayList<>();
		book.add(new Books("The good, the bad and the ugly", 5, 15.99, true));
		book.add(new Books("For a few dollars more", 6, 19.99, true));
		book.add(new Books("Fist full of travellers cheques", 7, 21.99, false));
		book.add(new Books("5 go mad in Dorset", 8, 10.99, true));
		book.add(new Books("Bad news", 9, 17.99, true));
		String savedBookJSON = this.mapper.writeValueAsString(book);
		
		// _______________________________When___________________________________
		RequestBuilder request = get("/getAllBooks");
		ResultMatcher responseStatus = status().isOk();
		ResultMatcher responseContent = content().json(savedBookJSON);
		
		// _______________________________Then___________________________________
		this.mvc.perform(request).andExpect(responseStatus).andExpect(responseContent);
	}


	
	
	
	// __________________________________________________________________________

	// _______________________Test method for GetByIndex________________________
	
	@Test
	void testGetByIndex() throws Exception {
		
		// _______________________________Given___________________________________
		Books savedBook = new Books("Bad news", 9, 17.99, true);
		String savedBookJSON = this.mapper.writeValueAsString(savedBook);
		
		// _______________________________When___________________________________
		RequestBuilder req = get("/getByIndex/9");
		ResultMatcher responseStatus = status().isOk();
		ResultMatcher responseContent = content().json(savedBookJSON);
		
		// _______________________________Then___________________________________
		this.mvc.perform(req).andExpect(responseStatus).andExpect(responseContent);
	}


	
	
	
	// __________________________________________________________________________

	// ______________________Test method for updateBooks________________________
	
	@Test
	void testUpdateBooks() throws Exception {
		
		// _______________________________Given___________________________________
		Books updatedBook = new Books("Ready player one", 9.98, true);
		String updatedBookJSON = this.mapper.writeValueAsString(updatedBook);

		Books matchedBook = new Books("Ready player one", 9, 9.98, true);
		String matchedBookJSON = this.mapper.writeValueAsString(matchedBook);
		
		// _______________________________When___________________________________
		RequestBuilder req = put("/updateBook/9").contentType(MediaType.APPLICATION_JSON).content(updatedBookJSON);
		ResultMatcher responseStatus = status().isAccepted();
		ResultMatcher responseContent = content().json(matchedBookJSON);
		
		// _______________________________Then___________________________________
		this.mvc.perform(req).andExpect(responseStatus).andExpect(responseContent);
	}
	
	
	
	
	// __________________________________________________________________________

	// ______________________Test method for Landing Page________________________
	
	@Test
	public void landingTest() throws Exception {
		this.mvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Welcome to the landing page, please select either /create, /delete(id), /getAllBooks, /getByIndex/(id), or /updateBook/(id)")));
	}

}
