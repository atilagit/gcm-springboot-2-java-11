package com.gcmmogi.gcm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.Oficial;
import com.gcmmogi.gcm.repositories.OficialRepository;

@Service
public class OficialService {
	
	@Autowired
	private OficialRepository repository;
	
	public List<Oficial> findAll(){
		return repository.findAll();
	}
	
	public Oficial findById(Long id) {
		Optional<Oficial> obj = repository.findById(id);
		return obj.get();
	}
	
	public Oficial insert(Oficial obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Oficial update(Long id, Oficial obj) {
		Oficial entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Oficial entity, Oficial obj) {
		entity.setLogin(obj.getLogin());
		entity.setNome(obj.getNome());
		entity.setTime(obj.getTime());
		entity.setViatura(obj.getViatura());
		entity.setPosto(obj.getPosto());
	}
}
