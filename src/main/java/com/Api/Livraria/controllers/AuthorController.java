package com.Api.Livraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Api.Livraria.dto.AuthorDto;
import com.Api.Livraria.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@PostMapping
	public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(authorService.createAuthor(authorDto));
	}
	
	@PostMapping("/bulk")
	public ResponseEntity<?> createMany(@RequestBody List<AuthorDto> dtos){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(authorService.createManyAuthors(dtos));
	}
	
}
