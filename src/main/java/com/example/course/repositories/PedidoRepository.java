package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	
	
}
