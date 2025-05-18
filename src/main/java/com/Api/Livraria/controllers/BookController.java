package com.Api.Livraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Api.Livraria.dto.BookDto;
import com.Api.Livraria.dto.BookResponseDto;
import com.Api.Livraria.entities.Book;
import com.Api.Livraria.services.BookService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
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
	public ResponseEntity<BookResponseDto> createBook(@RequestBody @Valid BookDto bookDto) {
		Book book = bookService.createBook(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.toDto(book));
	}

	@PostMapping("/bulk")
	public ResponseEntity<List<BookResponseDto>> createManyBooks(@RequestBody @Valid List<BookDto> bookDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createManyBooks(bookDto));
	}

	@GetMapping
	public ResponseEntity<List<BookResponseDto>> findAll() {
		return ResponseEntity.ok(bookService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookResponseDto> findBookById(@PathVariable Long id){
		return ResponseEntity.ok().body(bookService.findBookById(id));
	}

	@GetMapping("/search")
	public ResponseEntity <List<BookResponseDto>> findBookByTitle(@RequestParam String title){
		return ResponseEntity.ok().body(bookService.findBookByTitle(title));
	}
	
	@GetMapping("category/{categoryId}")
	public ResponseEntity<List<BookResponseDto>> searchBooksByCategoryId(@PathVariable Long categoryId){
		return ResponseEntity.ok().body(bookService.searchBooksByCategory(categoryId));
	}
	
	public void deleteBook(Book book) {
		bookService.deleteBook(book);
	}
}
