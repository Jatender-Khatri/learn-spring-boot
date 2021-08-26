package com.tools.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tools.test.Test;
import com.tools.test.entity.Book;

@RestController
public class BookController {
	@Autowired
	private Test test;

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return this.test.getAllBooks();
	}

	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") Integer id) {
		return test.getBookById(id);
	}

	@PostMapping("/createBook")
	public Book createBook(@RequestBody Book book) {
		Book b = this.test.createBook(book);
		System.out.println(b);
		return book;
	}

	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") Integer bookId) {
		this.test.deleteBook(bookId);
	}

	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") Integer bookId) {
		this.test.updateBook(book, bookId);
		return book;
	}
}
