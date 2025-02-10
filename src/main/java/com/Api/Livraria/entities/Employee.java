package com.Api.Livraria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "tb_funcionarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;	

	@NotBlank(message = "Nome é obrigatório")
	private String name;
    
	@Column(unique = true)
    private Integer  code;
    
	@NotBlank(message = "email é obrigatório")
	@Column(unique = true)
    private String email;
    
    private String role;
	
}
