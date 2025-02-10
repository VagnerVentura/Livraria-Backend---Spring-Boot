package com.Api.Livraria.entities;

import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class ItemSale {
	
	@Id
	private Long id;
	
	@OneToMany
	private List <Book> books;
	
	private int quantity;
	
}
