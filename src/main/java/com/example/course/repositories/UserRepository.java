package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
	
	
	
}
