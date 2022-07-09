package com.RestApi.SpringBootApi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApi.SpringBootApi.entity.Book;
import com.RestApi.SpringBootApi.repository.BookRepository;
import com.RestApi.SpringBootApi.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() 
	{
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> getBookById(Long id)
	{
		return bookRepository.findById(id);
	}

	@Override
	public Book createBook(Book book) 
	{
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBookById(long id) {
		bookRepository.deleteById(id);
	}
}
