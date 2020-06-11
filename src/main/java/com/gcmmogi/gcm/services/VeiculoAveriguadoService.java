package com.gcmmogi.gcm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.VeiculoAveriguado;
import com.gcmmogi.gcm.repositories.VeiculoAveriguadoRepository;

@Service
public class VeiculoAveriguadoService {
	
	@Autowired
	private VeiculoAveriguadoRepository repository;
	
	public List<VeiculoAveriguado> findAll(){
		return repository.findAll();
	}
	
	public VeiculoAveriguado findById(Long id) {
		Optional<VeiculoAveriguado> obj = repository.findById(id);
		return obj.get();
	}
}
