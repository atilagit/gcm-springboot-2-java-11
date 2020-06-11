package com.gcmmogi.gcm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.Bairro;
import com.gcmmogi.gcm.repositories.BairroRepository;

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
}
