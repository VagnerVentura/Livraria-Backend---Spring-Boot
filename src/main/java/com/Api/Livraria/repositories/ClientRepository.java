package com.Api.Livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Api.Livraria.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
