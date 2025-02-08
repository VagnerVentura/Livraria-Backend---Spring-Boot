package com.Api.Livraria.dto;

public record BookDto(String name,
		String author,
		String editor,
		String barcode,
		Integer stock) {

}
