package com.Api.Livraria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Api.Livraria.entities.Client;
import com.Api.Livraria.repositories.ClientRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

}
