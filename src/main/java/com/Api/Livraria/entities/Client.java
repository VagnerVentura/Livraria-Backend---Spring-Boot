package com.Api.Livraria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_clients")
public class Client{

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	private String name;
	
	@NotBlank(message = "cpf é obrigatório")
	@Column(unique = true)
	private String cpf;
	
	@NotBlank(message = "endereço é obrigatório")
	private String address;
	
	@NotBlank(message = "email é obrigatório")
	@Column(unique = true)
	private String email;
	
	private String password;
	
}
