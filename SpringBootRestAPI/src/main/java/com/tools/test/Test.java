package com.tools.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tools.test.entity.Book;

@Component
public class Test {
	private static List<Book> books = new ArrayList<>();

	// Add book Through Rest API
	// Tester API(Postman)
	static {
		books.add(new Book(2, "C++", "Jatender", 120.0));
		books.add(new Book(3, "C++", "Jatender", 120.0));
		books.add(new Book(4, "C++", "Jatender", 120.0));
	}

	// Get All Books
	public List<Book> getAllBooks() {
		return books;
	}

	// Get Book By Id
	public Book getBookById(Integer id) {
		Book book = null;
		book = books.stream().filter(e -> e.getBookId() == id).findFirst().get();

		return book;
	}

	// Create Book
	public Book createBook(Book b) {
		books.add(b);
		return b;
	}

	// Delete Book
	public void deleteBook(Integer bookId) {
		books = books.stream().filter(book -> book.getBookId() != bookId).collect(Collectors.toList());
	}
	
	// Update Book
	
	public void updateBook(Book book, Integer bookId)
	{
		books =  books.stream().map(b->
		{
			if(b.getBookId()==bookId)
			{
				b.setAuthor(book.getAuthor());
				b.setBookName(book.getBookName());
				b.setPrice(book.getPrice());
				b.setBookId(bookId);
			}
			return b;
		}).collect(Collectors.toList());
	}
}
