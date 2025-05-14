package com.Api.Livraria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Api.Livraria.dto.BookDto;
import com.Api.Livraria.entities.Book;
import com.Api.Livraria.repositories.SaleRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SaleService {

	private SaleRepository saleRepository;
	
//	public Book createS (BookDto bookDto) {
//		
//		Book book = new Book(
//				null,
//				bookDto.name(),
//				bookDto.author(),
//				bookDto.editor(),
//				bookDto.barcode(),
//				bookDto.stock(),
//				bookDto.nmrPaginas(),
//				bookDto.price(),null
//				);
//		
//		return bookRepository.save(book);
//	}
//
//	public List<Book> findAll() {
//		 return bookRepository.findAll();
//	}
//
//	public void deleteBook(Book book) {
//		bookRepository.delete(book);
//	}
}
