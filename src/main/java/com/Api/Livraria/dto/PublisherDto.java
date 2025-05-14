package com.Api.Livraria.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublisherDto {

	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
	private String name;

	@NotBlank(message = "O CNPJ é obrigatório.")
	@Pattern(regexp = "\\d{14}", message = "CNPJ deve conter exatamente 14 dígitos numéricos, sem pontuação.")
	private String cnpj;

	@NotBlank(message = "O e-mail é obrigatório.")
	@Email(message = "Formato de e-mail inválido.")
	private String email;

	@NotBlank(message = "O telefone é obrigatório.")
	@Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter entre 10 e 11 dígitos (com DDD), apenas números.")
	private String phone;

	@Size(max = 100, message = "O website deve ter no máximo 100 caracteres.")
	private String website;

	@NotBlank(message = "O endereço é obrigatório.")
	@Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres.")
	private String addres;

}
