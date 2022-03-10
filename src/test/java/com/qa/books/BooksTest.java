/**
 * 
 */
package com.qa.books;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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

/**
 * @author aidan
 *
 */
@ExtendWith(MockitoExtension.class)
public class BooksTest {
	@Mock
	private Integer id;

	@Mock
	private Boolean inStock;

	@Mock
	private Double price;

	@Mock
	private String title;
	@InjectMocks
	private Books books;

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	protected static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.qa.books.Books#Books()}.
	 */
	@Test
	public void testBooks() {
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link com.qa.books.Books#Books(java.lang.String, java.lang.Integer, java.lang.Double, java.lang.Boolean)}.
	 */
	@Test
	public void testBooksStringIntegerDoubleBoolean() {
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link com.qa.books.Books#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link com.qa.books.Books#setTitle(java.lang.String)}.
	 */
	@Test
	public void testSetTitle() {
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link com.qa.books.Books#getId()}.
	 */
	@Test
	public void testGetId() {
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link com.qa.books.Books#setId(java.lang.Integer)}.
	 */
	@Test
	public void testSetId() {
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link com.qa.books.Books#getPrice()}.
	 */
	@Test
	public void testGetPrice() {
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link com.qa.books.Books#setPrice(java.lang.Double)}.
	 */
	@Test
	public void testSetPrice() {
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link com.qa.books.Books#getInStock()}.
	 */
	@Test
	public void testGetInStock() {
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link com.qa.books.Books#setInStock(java.lang.Boolean)}.
	 */
	@Test
	public void testSetInStock() {
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link com.qa.books.Books#toString()}.
	 */
	@Test
	public void testToString() {
		String result = "Books [title=\" + title + \", id=\" + id + \", price=\" + price + \", inStock=\" + inStock + \"]";

	}

}
