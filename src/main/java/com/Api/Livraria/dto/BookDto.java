package com.Api.Livraria.dto;

import java.math.BigDecimal;

public record BookDto(
		String name,
		String author,
		String editor,
		String barcode,
		Integer stock,
		Integer nmrPaginas,
		BigDecimal price
		) {

}
