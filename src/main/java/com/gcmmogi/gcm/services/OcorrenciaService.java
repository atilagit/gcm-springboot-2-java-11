package com.gcmmogi.gcm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.Ocorrencia;
import com.gcmmogi.gcm.repositories.OcorrenciaRepository;

@Service
public class OcorrenciaService {
	
	@Autowired
	private OcorrenciaRepository repository;
	
	public List<Ocorrencia> findAll(){
		return repository.findAll();
	}
	
	public Ocorrencia findById(Long id) {
		Optional<Ocorrencia> obj = repository.findById(id);
		return obj.get();
	}
}
