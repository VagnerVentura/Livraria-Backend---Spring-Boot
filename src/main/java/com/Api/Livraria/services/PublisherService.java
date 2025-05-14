package com.Api.Livraria.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Api.Livraria.Mappers.PublisherMapper;
import com.Api.Livraria.dto.PublisherDto;
import com.Api.Livraria.entities.Publisher;
import com.Api.Livraria.repositories.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	PublisherRepository publisherRepository;
	
	@Autowired
	PublisherMapper publisherMapper;
	
	public PublisherDto createPublisher(PublisherDto publisherDto) {
		var  entity = publisherRepository.save(publisherMapper.toentity(publisherDto));
		return  publisherMapper.toDto(entity);
	}
	
	public List<PublisherDto> createMany(List<PublisherDto> publisherDtos){
		List<PublisherDto> dtos = publisherDtos.stream()
		.map(p->{
			return createPublisher(p);
		}).collect(Collectors.toList());
		return dtos;
	}
	
	public Publisher findPublisherById(Long id) {
		return publisherRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Publisher not found !"));
	}
	
}
