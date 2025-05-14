package com.Api.Livraria.Mappers;

import java.util.List;

import com.Api.Livraria.dto.BookDto;
import com.Api.Livraria.entities.Author;
import com.Api.Livraria.entities.Book;
import com.Api.Livraria.entities.Category;
import com.Api.Livraria.entities.Publisher;

public class BookMapper {

    public Book toEntity(BookDto dto, Author author, Publisher publisher, List<Category> categories) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIsbnt(dto.getIsbnt());
        book.setStock(dto.getStock());
        book.setPrice(dto.getPrice());
        book.setPublicationDate(dto.getPublicationDate());
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setCategories(categories);
        return book;
    }

    public BookDto toDto(Book book) {
        BookDto dto = new BookDto();
        dto.setTitle(book.getTitle());
        dto.setIsbnt(book.getIsbnt());
        dto.setStock(book.getStock());
        dto.setPrice(book.getPrice());
        dto.setPublicationDate(book.getPublicationDate());
        dto.setAuthorId(book.getAuthor().getId());
        dto.setPublisherId(book.getPublisher().getId());
        dto.setCategoriesId(
            book.getCategories().stream().map(Category::getId).toList()
        );
        return dto;
    }
}
