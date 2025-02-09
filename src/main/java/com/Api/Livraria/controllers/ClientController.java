package com.Api.Livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Api.Livraria.entities.Client;
import com.Api.Livraria.services.ClientService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody Client client){
		return ResponseEntity.ok(clientService.createClient(client));
	}
}
