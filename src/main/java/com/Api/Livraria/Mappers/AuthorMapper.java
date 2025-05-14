package com.Api.Livraria.Mappers;

import org.springframework.stereotype.Component;

import com.Api.Livraria.dto.AuthorDto;
import com.Api.Livraria.entities.Author;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
public class  AuthorMapper {

	public Author toEntity (AuthorDto dto) {
		Author author = new Author();
		author.setName(dto.getName());
		author.setNationality(dto.getNationality());	
		author.setBiography(dto.getBiography());
		return author;
	}
	
	public AuthorDto toDto (Author author) {
		AuthorDto dto = new AuthorDto();
		dto.setName(author.getName());
		dto.setNationality(author.getNationality());
		return dto;
	}
	
}
