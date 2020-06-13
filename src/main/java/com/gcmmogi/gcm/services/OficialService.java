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
}
