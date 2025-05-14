package com.Api.Livraria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Api.Livraria.entities.Client;
import com.Api.Livraria.entities.Employee;
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

	public Client findById(Long id) {
		return clientRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Client not Found !"));
	}

}
