package com.raj.book.service;

import java.util.List;

import com.raj.book.model.Book;
import com.raj.book.model.BookAndUser;

public interface BookService {
	public Book saveBook(Book book);
	public Book getBookById(long bookId);
	public List<Book> getAllBooks();
	public Book updateBook(long bookId, Book book);
	public Book deleteBook(long bookId);
	public BookAndUser getUserByBook(long bookId);
}
