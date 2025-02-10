package com.Api.Livraria.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "tb_vendas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sale {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Client client;
	
	private List<ItemSale> books;
	
	private LocalDateTime date;
	
}
