package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entities.Produto;

public interface ProductRepository extends JpaRepository<Produto, Long> {
	
		
	
}
