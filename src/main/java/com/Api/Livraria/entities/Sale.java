package com.Api.Livraria.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private Employee employee;
	
	@OneToOne
	private Client client;
	
	@OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemSale> itemsSale;
	
	private LocalDateTime date;
	
}
