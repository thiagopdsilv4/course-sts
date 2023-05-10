package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);//retorna objeto tipo User, que estiver dentro do optional
		
		return obj.get();
	}
	
	public User insert(User obj) {//operação básica para inserir no bd um objeto tipo User
		return repository.save(obj);//save retorna o objeto salvo.
	}
	
	public void delete(Long id) {
		repository.deleteById(id);//delata do bd o usuário
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setPhone(obj.getPhone());
	}
}
