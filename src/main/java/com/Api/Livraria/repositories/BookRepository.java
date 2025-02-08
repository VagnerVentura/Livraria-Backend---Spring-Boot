package com.Api.Livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Api.Livraria.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
