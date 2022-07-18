package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entities.Categoria;

public interface CategoryRepository extends JpaRepository<Categoria, Long> {
	
	
	
}
