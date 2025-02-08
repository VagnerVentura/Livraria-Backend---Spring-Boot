package com.Api.Livraria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Api.Livraria.dto.BookDto;
import com.Api.Livraria.entities.Book;
import com.Api.Livraria.repositories.BookRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookService {

	private BookRepository bookRepository;
	
	public Book createBook (BookDto bookDto) {
		
		Book book = new Book(
				null,
				bookDto.name(),
				bookDto.author(),
				bookDto.editor(),
				bookDto.barcode(),
				bookDto.stock()
				);
		
		return bookRepository.save(book);
	}

	public List<Book> findAll() {
		 return bookRepository.findAll();
	}

	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}
}
