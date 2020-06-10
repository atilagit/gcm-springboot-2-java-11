package com.gcmmogi.gcm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.Envolvido;
import com.gcmmogi.gcm.repositories.EnvolvidoRepository;

@Service
public class EnvolvidoService {
	
	@Autowired
	private EnvolvidoRepository repository;
	
	public List<Envolvido> findAll(){
		return repository.findAll();
	}
	
	public Envolvido findById(Long id) {
		Optional<Envolvido> obj = repository.findById(id);
		return obj.get();
	}
}
