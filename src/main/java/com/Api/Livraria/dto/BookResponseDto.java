package com.Api.Livraria.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
	
	private Long id;
	private String Title;
	private String authorName;
	private String publisherName;
	private LocalDate publicationDate;
	private List<String> categoriesNames;
	private BigDecimal price;
	
}
