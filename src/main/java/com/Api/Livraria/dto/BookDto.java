package com.Api.Livraria.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto{
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String isbnt;
	
    @NotNull
    @PastOrPresent(message = "The publication date cannot be in the future")
	private LocalDate publicationDate;
	
	@NotNull
	@PositiveOrZero
	private Integer stock;
	
	@NotNull
	@DecimalMin(value = "0.0")
	private BigDecimal price; 
	
	@NotNull
	private Long authorId;
	
	@NotNull
	private Long publisherId;
	
	@NotEmpty
	private List<Long> categoriesId;
}
