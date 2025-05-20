package com.Api.Livraria.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewDto {
	
    @Min(1)
    @Max(5)
	private int note;
    
    @NotBlank
    @Size(max = 500)
	private String comment;
    
    @PastOrPresent
	private LocalDate date;
    
    @NotNull
	private Long clientId;
    
    @NotNull
	private Long bookId; 
	
}
