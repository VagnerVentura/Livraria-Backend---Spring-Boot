package com.Api.Livraria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.Api.Livraria.Mappers.ReviewMapper;
import com.Api.Livraria.dto.ReviewDto;
import com.Api.Livraria.dto.ReviewResponseDto;
import com.Api.Livraria.entities.Review;
import com.Api.Livraria.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	public  ReviewResponseDto createReview(ReviewDto dto){
		var client = clientService.findById(dto.getClientId()); 
		var book = bookService.findBookById(dto.getBookId()); 
		var review = reviewMapper.toEntity(dto, client, book);		
		return reviewMapper.toDto(reviewRepository.save(review));
	}
	
}
