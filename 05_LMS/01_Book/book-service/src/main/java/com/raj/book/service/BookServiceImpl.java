package com.raj.book.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.raj.book.model.Book;
import com.raj.book.model.BookAndUser;
import com.raj.book.model.User;
import com.raj.book.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book getBookById(long bookId) {
		return bookRepository.findById(bookId).get();
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book updateBook(long bookId, Book book) {
		Book bookdb = bookRepository.findById(bookId).get();
		if(Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle())) {
			bookdb.setTitle(book.getTitle());
		}
		
		if(Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())) {
			bookdb.setAuthor(book.getAuthor());
		}
		
		if(Objects.nonNull(book.getCost()) && !"".equalsIgnoreCase(String.valueOf(book.getCost()))) {
			bookdb.setCost(book.getCost());
		}
		
		if(Objects.nonNull(book.getUserId()) && !"".equalsIgnoreCase(String.valueOf(book.getUserId()))) {
			bookdb.setUserId(book.getUserId());
		}
		
		return bookRepository.save(bookdb);
	}

	@Override
	public Book deleteBook(long bookId) {
		Book book = bookRepository.findById(bookId).get();
		bookRepository.deleteById(bookId);
		return book;
	}
	
	@Override
	public BookAndUser getUserByBook(long bookId) {
		BookAndUser bookUser = new BookAndUser();
		Book book = bookRepository.findById(bookId).get();
		User user = restTemplate.getForObject("http://USER-SERVICE/users/" + book.getUserId(), User.class);		
		bookUser.setBook(book);
		bookUser.setUser(user);
		return bookUser;
	}

}
