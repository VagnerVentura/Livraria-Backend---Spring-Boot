package com.Api.Livraria.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Api.Livraria.Mappers.AuthorMapper;
import com.Api.Livraria.dto.AuthorDto;
import com.Api.Livraria.entities.Author;
import com.Api.Livraria.repositories.AuthorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	AuthorMapper authorMapper;
	
	
	public AuthorDto createAuthor(AuthorDto dto) {
		Author author = new Author();
		author.setName(dto.getName());
		author.setBiography(dto.getBiography());
		Author authorSaved = authorRepository.save(author);
		return authorMapper.toDto(authorSaved);
	}

	public List<AuthorDto> createManyAuthors(List<AuthorDto> dtos) {
		List<Author> authors = dtos
				.stream()
				.map(a -> {
				   return authorRepository.save(authorMapper.toEntity(a));
				}).collect(Collectors.toList());
		
		 List<AuthorDto> authorsDto = authors
				.stream()
				.map(a->{
					return authorMapper.toDto(a);
		}).collect(Collectors.toList());
		 return authorsDto;
	}
	
	public Author findAuthorById(Long id) {
		return authorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Author not Found!"));
	}
}
