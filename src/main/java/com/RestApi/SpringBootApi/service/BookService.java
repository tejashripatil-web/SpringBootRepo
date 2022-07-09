package com.RestApi.SpringBootApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RestApi.SpringBootApi.entity.Book;

@Service
public interface BookService {

	public List<Book> getAllBooks();

	public Optional<Book> getBookById(Long id);

	public Book createBook(Book book);

	public Book updateBook(Book book);

	public void deleteBookById(long id);

}
