package com.Api.Livraria.Mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.Api.Livraria.dto.PublisherDto;
import com.Api.Livraria.dto.PublisherResponseDto;
import com.Api.Livraria.entities.Book;
import com.Api.Livraria.entities.Publisher;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class PublisherMapper {

	public Publisher toentity(PublisherDto publisherDto) {
		Publisher publisher = new Publisher();
		publisher.setName(publisherDto.getName());
		publisher.setCnpj(publisherDto.getCnpj());
		publisher.setEmail(publisherDto.getEmail());
		publisher.setPhone(publisherDto.getPhone());
		publisher.setWebsite(publisherDto.getWebsite());
		publisher.setAddres(publisherDto.getAddres());
		return publisher;
	}
	
	public PublisherDto toDto(Publisher publisher) {
		PublisherDto dto = new PublisherDto();
		dto.setName(publisher.getName());
		dto.setCnpj(publisher.getCnpj());
		dto.setEmail(publisher.getEmail());
		dto.setPhone(publisher.getPhone());
		dto.setWebsite(publisher.getWebsite());
		dto.setAddres(publisher.getAddres());
		return dto;
	}
	
	public PublisherResponseDto toResponseDto(Publisher publisher) {
		PublisherResponseDto response = new PublisherResponseDto();
			response.setName(publisher.getName());
			List <String> bookNames = publisher.getBooks()
					.stream()
					.map(Book::getTitle)
			.collect(Collectors.toList());
			response.setBookNames(bookNames);
		return response;
	}
	
}
