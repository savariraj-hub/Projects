package com.raj.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raj.book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	public List<Book> findByTitleIgnoreCase(String title);
	public List<Book> findByAuthorIgnoreCase(String author);
}
