package com.Api.Livraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Api.Livraria.dto.BookDto;
import com.Api.Livraria.entities.Book;
import com.Api.Livraria.services.BookService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<Book>  createBook(@RequestBody BookDto bookDto) {
		Book book = bookService.createBook(bookDto);	
		return ResponseEntity.ok(book);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll(){
		return ResponseEntity.ok(bookService.findAll());
	}
	
	public void deleteBook(Book book) {
		bookService.deleteBook(book);
	}
}
