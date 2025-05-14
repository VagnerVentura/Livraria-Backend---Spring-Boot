package com.Api.Livraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Api.Livraria.dto.PublisherDto;
import com.Api.Livraria.services.PublisherService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/publishers")
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	@PostMapping
	public ResponseEntity<PublisherDto> createPublisher(@Valid @RequestBody PublisherDto publisherDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(publisherService.createPublisher(publisherDto));
	}
	
	@PostMapping("/bulk")
	public ResponseEntity<?> createManyPublishers( @Valid @RequestBody List<PublisherDto> publishers){
		return ResponseEntity.status(HttpStatus.CREATED).body(publisherService.createMany(publishers));
	}
	
}
