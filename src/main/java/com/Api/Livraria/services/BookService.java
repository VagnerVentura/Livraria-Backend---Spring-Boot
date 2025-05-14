package com.Api.Livraria.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Api.Livraria.dto.BookDto;
import com.Api.Livraria.dto.BookResponseDto;
import com.Api.Livraria.entities.Author;
import com.Api.Livraria.entities.Book;
import com.Api.Livraria.entities.Category;
import com.Api.Livraria.entities.Publisher;
import com.Api.Livraria.repositories.BookRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PublisherService publisherService;	

	public Book createBook (@RequestBody BookDto bookDto ){
		Book book = new Book();
		
		Author author = authorService.findAuthorById(bookDto.getAuthorId());		
		List<Category> categories = categoryService.findCategoryById(bookDto.getCategoriesId());		
		Publisher publisher = publisherService.findPublisherById(bookDto.getPublisherId());		
		
		book.setTitle(bookDto.getTitle());
		book.setPublicationDate(bookDto.getPublicationDate());
		book.setIsbnt(bookDto.getIsbnt());
		book.setStock(bookDto.getStock());
		book.setPrice(bookDto.getPrice());
		
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setCategories(categories);		
		
		bookRepository.save(book);
		return book;
	}
	
	public List<BookResponseDto> createManyBooks(List<BookDto> books){
		List<BookResponseDto> Allbooks = books.stream()
		.map(b->{
			var book = createBook(b);
			return toDto(book);
		})
		.collect(Collectors.toList());		
		return Allbooks;
	}

	public List<BookResponseDto> findAll() {
		 List<BookResponseDto> response =  bookRepository.findAll()
				 .stream()
				 .map(b ->{
					 BookResponseDto book = new BookResponseDto();
					 book.setTitle(b.getTitle());
					 book.setAuthorName(b.getAuthor().getName());
					 book.setPublisherName(b.getPublisher().getName());
					 book.setPublicationDate(b.getPublicationDate());
					 book.setPrice(b.getPrice());
					 
					 List<String> categories = b.getCategories()
							 .stream()
							 .map(c -> c.getName()).toList();
					 
					 book.setCategoriesNames(categories);
					 
					 return book;
				 }).collect(Collectors.toList());
		 
		 return response;
	}

	public Book findById(Long bookId) {
	 var book = bookRepository.findById(bookId)
			 .orElseThrow(() -> new RuntimeException("book not Found!"));		
		return book;
	}
	
	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}

	public BookResponseDto toDto(Book book) {
		BookResponseDto dto = new BookResponseDto();
		
		dto.setId(book.getId());
		dto.setTitle(book.getTitle());
		dto.setAuthorName(book.getAuthor().getName());
		dto.setPublisherName(book.getPublisher().getName());
		dto.setPublicationDate(book.getPublicationDate());
		dto.setPrice(book.getPrice());
		dto.setCategoriesNames(book.getCategories()
				.stream()
				.map(Category::getName).toList());		
		return dto;
	}
	
}
