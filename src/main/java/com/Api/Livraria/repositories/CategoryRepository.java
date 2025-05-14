package com.Api.Livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Api.Livraria.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	
}
