package com.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.books.Books;

@Repository
public interface Repo extends JpaRepository<Books, Integer> {

	@Query("SELECT book from Books book")
	List<Books> findAllJPQL();

	@Query(value = "SELECT * from Books", nativeQuery = true)
	List<Books> findAllSQL();

}
