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
		List<Category> categories = categoryService.findCategoriesById(bookDto.getCategoriesId());		
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

	public BookResponseDto findBookById(Long id){
		Book entity = bookRepository.findById(id)
				.orElseThrow( ()-> new RuntimeException("Book Not Found!"));
		return toDto(entity);
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
	
	public List<BookResponseDto> findBookByTitle(String title) {
		List<Book> entity = bookRepository.findByTitleContainingIgnoreCase(title);
		
		List<BookResponseDto> books = entity.stream()
				.map(br-> {
					BookResponseDto book = new BookResponseDto();
					book.setTitle(br.getTitle());
					book.setAuthorName(br.getAuthor().getName());
					book.setPublisherName(br.getPublisher().getName());
					book.setPrice(br.getPrice());
					
					List<String> names = br.getCategories()
							.stream()
							.map(n ->{
								return n.getName();
							}).collect(Collectors.toList());					
					book.setCategoriesNames(names);
					return book;
				}).collect(Collectors.toList());
		
		return books;		
	}
	
	public List<BookResponseDto> searchBooksByCategory(Long categoryId){
		Category category = categoryService.findCategoryById(categoryId);
		
		List<BookResponseDto> books = category.getBooks()
		.stream()
		.map(book->{
			BookResponseDto dtos = new BookResponseDto();
			dtos.setTitle(book.getTitle());
			dtos.setAuthorName(book.getAuthor().getName());
			dtos.setPrice(book.getPrice());
			dtos.setPublicationDate(book.getPublicationDate());
			dtos.setPublisherName(book.getPublisher().getName());			
			dtos.setCategoriesNames(book.getCategories()
					.stream()
					.map(Category::getName).collect(Collectors.toList()));			
			return dtos;
		}).collect(Collectors.toList());		
		return books;
	}
	
}
