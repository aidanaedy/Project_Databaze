/**
 * 
 */
package com.qa.books;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import lombok.Data;

// __________________________________________________________________________

// __________________________Test For The Books File__________________________


@Data

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

	@Autowired
	private MockMvc mvc;




}
