package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Usuario;
import com.example.course.repositories.UserRepository;
import com.example.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Usuario update(Long id, Usuario obj) {
		Usuario entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
