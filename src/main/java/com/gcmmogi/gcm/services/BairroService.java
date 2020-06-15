package com.gcmmogi.gcm.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.Bairro;
import com.gcmmogi.gcm.repositories.BairroRepository;
import com.gcmmogi.gcm.services.exceptions.DatabaseException;
import com.gcmmogi.gcm.services.exceptions.ResourceNotFoundException;

@Service
public class BairroService {
	
	@Autowired
	private BairroRepository repository;
	
	public List<Bairro> findAll(){
		return repository.findAll();
	}
	
	public Bairro findById(Long id) {
		Optional<Bairro> obj = repository.findById(id);
		return obj.get();
	}
	
	public Bairro insert(Bairro obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Bairro update(Long id, Bairro obj) {
		try {
			Bairro entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Bairro entity, Bairro obj) {
		entity.setNome(obj.getNome());
	}
}
