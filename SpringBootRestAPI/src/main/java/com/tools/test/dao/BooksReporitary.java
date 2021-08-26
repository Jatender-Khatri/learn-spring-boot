package com.tools.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.tools.test.entity.Book;

public interface BooksReporitary extends CrudRepository<Book, Integer>{

}
