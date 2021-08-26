package com.tools.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	/*
	 * Without HTTP Code
	 * 
	 * @GetMapping("/books") public List<Book> getAllBooks() { return
	 * this.test.getAllBooks(); }
	 */

	// Get All Record Through HTTP Message
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> list = test.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	/*
	 * Get Book By id Without HTTP Message
	 * 
	 * @GetMapping("/books/{id}") public Book getBookById(@PathVariable("id")
	 * Integer id) { return test.getBookById(id); }
	 */

	// Get Reocrd By ID Through HTTP Message
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {

		Book book = test.getBookById(id);
		if (book != null) {
			return ResponseEntity.of(Optional.of(book));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	/*
	 * Create Book Without HttP Message
	 * 
	 * @PostMapping("/createBook") public Book createBook(@RequestBody Book book) {
	 * Book b = this.test.createBook(book); System.out.println(b); return book; }
	 */

	// Create Record Through HHTP Message
	@PostMapping("/createBook")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book b = null;
		try {
			b = this.test.createBook(b);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/*
	 * Delete Book Without HTTP Message
	 * 
	 * @DeleteMapping("/books/{id}") public void deleteBook(@PathVariable("id")
	 * Integer bookId) { this.test.deleteBook(bookId); }
	 */

	// Delete Record Through HTTP Message
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer bookId) {

		try {
			this.test.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/*
	 * Update Book Without HTTP Message
	 * 
	 * @PutMapping("/books/{bookId}") public Book updateBook(@RequestBody Book
	 * book, @PathVariable("bookId") Integer bookId) { this.test.updateBook(book,
	 * bookId); return book; }
	 */

	// Update Reocrd Through HTTP Message
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") Integer bookId) {
		try {
			this.test.updateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
