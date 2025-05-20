package com.Api.Livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Api.Livraria.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
