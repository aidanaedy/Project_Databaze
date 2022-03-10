package com.qa.bookService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.books.Books;
import com.qa.repo.Repo;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	@Mock
	private Repo repo;
	@InjectMocks
	private BookService bookService;



	@Test
	public void testBookService() {
		throw new RuntimeException("not yet implemented");
	}
	


	@Test
	public void testCreateBook() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetAllBooks() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetAll() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetId() {
		//Given
		int id = 5;
		Books foundPerson = new Books("The good, the bad and the ugly",5, 15.99, true);
		//When
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(foundPerson));
		//Then
		assertThat(this.bookService.getId(id)).isEqualTo(foundPerson);
		//Verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyInt());
	}

	@Test
	public void testUpdateBooks() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testDeleteBook() {
		throw new RuntimeException("not yet implemented");
	}

}
