package com.RestApi.SpringBootApi.controller;

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

import com.RestApi.SpringBootApi.entity.Book;
import com.RestApi.SpringBootApi.service.BookService;

@RestController
public class BookController {
	@Autowired BookService  bookService;
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		return new ResponseEntity <List<Book>>(bookService.getAllBooks(),HttpStatus.FOUND);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id)
	{
		Optional<Book> book= bookService.getBookById(id);
		if(book==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/book")
	public ResponseEntity<Book> createBook(@RequestBody Book book)
	{
		try
		{
			Book b=bookService.createBook(book);
			return ResponseEntity.of(Optional.of(b));
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	@PutMapping("/book")
	public ResponseEntity<Book> updateBook(@RequestBody Book book)
	{
		try
		{
			bookService.updateBook(book);
			return ResponseEntity.ok().body(book);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> deleteBookById(@PathVariable long id)
	{
		try
		{
			bookService.deleteBookById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		 
	}
}
