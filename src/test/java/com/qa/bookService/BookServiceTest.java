package com.qa.bookService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.qa.books.Books;
import com.qa.repo.Repo;
import com.qa.scrape.Scrape;

import lombok.Data;

@Data

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	// __________________________________________________________________________

	// ______________________Test For The BooksService File_______________________

	@Mock
	private Repo repo;

	@InjectMocks
	private BookService bookService;
	
	@Test
	void Loads() {
	}

	@Test
	public void testBookService() throws IOException {
		Scrape.Scrape();
	}


	// __________________________________________________________________________

	// ______________________Test method for CreateBook_________________________
	@Test
	public void testCreateBook() {
		// Given
		Books bookToSave = new Books();
		Books bookSaved = new Books();
		// When
		Mockito.when(this.repo.save(bookToSave)).thenReturn(bookSaved);
		// Then
		assertThat(this.bookService.createBook(bookToSave)).isEqualTo(bookSaved);
		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Books.class));
	}


	
	
	
	// __________________________________________________________________________

	// ______________________Test method for GetAllBooks________________________
	
	@Test
	public void testGetAllBooks() throws Exception {
		// Given
		List<Books> book = new ArrayList<>();
		book.add(new Books("The good, the bad and the ugly", 5, 15.99, true));
		book.add(new Books("For a few dollars more", 6, 19.99, true));
		book.add(new Books("Fist full of travellers cheques", 7, 21.99, false));
		book.add(new Books("5 go mad in Dorset", 8, 10.99, true));
		book.add(new Books("Bad news", 9, 17.99, true));

		get("/getAllBooks");
		status().isOk();

	}

	
	
	// __________________________________________________________________________

	// _________________________Test method for GetId____________________________
		
	@Test
	public void testGetId() {
		// Given
		int id = 5;
		Books foundBook = new Books("The good, the bad and the ugly", 5, 15.99, true);
		// When
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(foundBook));
		// Then
		assertThat(this.bookService.getId(id)).isEqualTo(foundBook);
		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyInt());
	}

	
	
	
	// __________________________________________________________________________

	// _____________________Test method for UpdateBooks ________________________

	@Test
	public void testUpdateBooks() {
		// Given
		int id = 9;
		Books savedBook = new Books("Bad News", 9, 17.99, true);
		Books preUpdate = new Books("Bad News", 9, 17.99, true);
		Books postUpdate = new Books("Bad News", 9, 17.99, true);
		// When
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(savedBook));
		Mockito.when(this.repo.save(postUpdate)).thenReturn(postUpdate);
		// Then
		Assertions.assertThat(this.bookService.updateBooks(id, preUpdate)).isEqualTo(postUpdate);
		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyInt());
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Books.class));
	}

	
	
	
	// __________________________________________________________________________

	// ______________________Test method for DeleteBook ________________________
	
	@Test
	public void testDeleteBook() {
		int id = 6;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		Assertions.assertThat(this.bookService.deleteBook(id)).isTrue();

		Mockito.verify(this.repo, Mockito.times(1)).deleteById(Mockito.anyInt());
		Mockito.verify(this.repo, Mockito.times(1)).existsById(Mockito.anyInt());
	}
	
	@Test
	void loaded() {
		assertThat(BookService.class).isNotNull();
		}

}
