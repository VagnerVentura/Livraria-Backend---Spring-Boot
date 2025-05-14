package com.Api.Livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Api.Livraria.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>{

}
