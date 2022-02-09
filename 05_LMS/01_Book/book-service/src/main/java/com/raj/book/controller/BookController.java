package com.raj.book.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.book.model.Book;
import com.raj.book.model.BookAndUser;
import com.raj.book.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public Book saveBook(@Valid @RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{bookId}")
	public Book getBooksById(@PathVariable("bookId") long bookId) {
		return bookService.getBookById(bookId);
	}
	
	@PutMapping("/{bookId}")
	public Book updateBook(@PathVariable("bookId") long bookId, @RequestBody Book book) {
		return bookService.updateBook(bookId, book);
	}
	
	@DeleteMapping("/{bookId}")
	public Book deleteBook(@PathVariable("bookId") long bookId) {
		return bookService.deleteBook(bookId);
	}
	
	@GetMapping("/book-user/{bookId}")
	public BookAndUser getUserByBook(@PathVariable("bookId") long bookId) {
		return bookService.getUserByBook(bookId);
	}
}
