package com.Api.Livraria.Mappers;

import com.Api.Livraria.dto.ReviewDto;
import com.Api.Livraria.dto.ReviewResponseDto;
import com.Api.Livraria.entities.Book;
import com.Api.Livraria.entities.Client;
import com.Api.Livraria.entities.Review;

public class ReviewMapper {

	
	public Review toEntity(ReviewDto dto, Client client, Book book) {
		Review review = new Review();
		review.setBook(book);
		review.setClient(client);
		review.setComment(dto.getComment());
		review.setNote(dto.getNote());
		review.setDate(dto.getDate());
		return review;		
	}
	
	public ReviewResponseDto toDto(Review entity){
		ReviewResponseDto dto = new ReviewResponseDto(); 
		dto.setClientName(entity.getClient().getName());
		dto.setBookTitle(entity.getBook().getTitle());
		dto.setDate(entity.getDate());
		dto.setNote(entity.getNote());
		dto.setComment(entity.getComment());		
		return dto;
	}
	
}
