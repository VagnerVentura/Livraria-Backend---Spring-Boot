package com.Api.Livraria.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewResponseDto {

	private String clientName;
	private String bookTitle;
	private LocalDate date;
	private int note;
	private String comment;
}
