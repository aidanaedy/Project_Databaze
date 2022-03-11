package com.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.books.Books;


// __________________________________________________________________________

// __________________________SQL query repository____________________________

@Repository
public interface Repo extends JpaRepository<Books, Integer> {

	@Query("SELECT book from Books book")
	List<Books> findAllJPQL();

	@Query(value = "SELECT * from Books", nativeQuery = true)
	List<Books> findAllSQL();

	List<Books> findBooksBytitleIsNotNull();

	@Query("SELECT book from Books book WHERE book.title != NULL")
	List<Books> findBooksByTitleIsNotNullJPQL();

	@Query(value = "SELECT * from Books WHERE title IS NOT NULL", nativeQuery = true)
	List<Books> findBooksByTitleIsNotNullSQL();

	List<Books> findBooksByTitleIsNull();

	@Query("SELECT book from Books book WHERE book.title = NULL")
	List<Books> findBooksByTitleIsNullJPQL();

	@Query(value = "SELECT * from Books WHERE title IS NULL", nativeQuery = true)
	List<Books> findBooksByTitleIsNullSQL();

	@Query("SELECT book from Books book WHERE book.price > ?1")
	List<Books> findBooksByPriceGreaterThanJPQL(Double price);

	@Query(value = "SELECT * from Books WHERE price > ?1", nativeQuery = true)
	List<Books> findBooksByPriceGreaterThanSQL(Double price);

	List<Books> findBooksByPriceLessThan(Double price);

	@Query("SELECT book from Books book WHERE book.price < ?1")
	List<Books> findBooksByPriceLessThanJPQL(Double price);

	@Query(value = "SELECT * from Books WHERE price < ?1", nativeQuery = true)
	List<Books> findBooksByPriceLessThanSQL(Double price);

	List<Books> findBooksByTitle(String title);

	@Query("SELECT book from Books book WHERE book.title = ?1")
	List<Books> findBooksByTitleJPQL(String title);

	@Query(value = "SELECT * from Books WHERE title = ?1", nativeQuery = true)
	List<Books> findBooksByTitleSQL(String title);

	Books findBooksByTitleAndPrice(String title, Double price);

	@Query("SELECT book from Books book WHERE book.title = ?1 and book.price = ?2")
	Books findBooksByTitleAndPriceJPQL(String title, Double price);

	@Query(value = "SELECT * from Books WHERE title = ?1 and price = ?2", nativeQuery = true)
	Books findBooksByTitleAndPriceSQL(String title, Double price);

}
