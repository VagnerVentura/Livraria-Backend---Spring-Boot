package com.Api.Livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Api.Livraria.dto.ReviewDto;
import com.Api.Livraria.dto.ReviewResponseDto;
import com.Api.Livraria.services.ReviewService;

import jakarta.validation.Valid;

@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	@PostMapping
	public ResponseEntity<ReviewResponseDto> createReviews(@Valid @RequestBody ReviewDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.createReview(dto));
	}
	
}
