package com.gcmmogi.gcm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.RG;
import com.gcmmogi.gcm.repositories.RGRepository;

@Service
public class RGService {
	
	@Autowired
	private RGRepository repository;
	
	public List<RG> findAll(){
		return repository.findAll();
	}
	
	public RG findById(Long id) {
		Optional<RG> obj = repository.findById(id);
		return obj.get();
	}
}
