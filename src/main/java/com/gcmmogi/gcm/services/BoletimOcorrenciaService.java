package com.gcmmogi.gcm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.BoletimOcorrencia;
import com.gcmmogi.gcm.repositories.BoletimOcorrenciaRepository;

@Service
public class BoletimOcorrenciaService {
	
	@Autowired
	private BoletimOcorrenciaRepository repository;
	
	public List<BoletimOcorrencia> findAll(){
		return repository.findAll();
	}
	
	public BoletimOcorrencia findById(Long id) {
		Optional<BoletimOcorrencia> obj = repository.findById(id);
		return obj.get();
	}
}
