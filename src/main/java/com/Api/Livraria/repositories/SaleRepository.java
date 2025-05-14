package com.Api.Livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Api.Livraria.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
