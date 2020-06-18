package com.gcmmogi.gcm.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.Ocorrencia;
import com.gcmmogi.gcm.repositories.OcorrenciaRepository;
import com.gcmmogi.gcm.services.exceptions.DatabaseException;
import com.gcmmogi.gcm.services.exceptions.ResourceNotFoundException;

@Service
public class OcorrenciaService {
	
	@Autowired
	private OcorrenciaRepository repository;
	
	public List<Ocorrencia> findAll(){
		return repository.findAll();
	}
	
	public Ocorrencia findById(Long id) {
		Optional<Ocorrencia> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Ocorrencia insert(Ocorrencia obj) {
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
	
	public Ocorrencia update(Long id, Ocorrencia obj) {
		try {
			Ocorrencia entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Ocorrencia entity, Ocorrencia obj) {
		entity.setCodigoDaOcorrencia(obj.getCodigoDaOcorrencia());
		entity.setNaturezaDaOcorrencia(obj.getNaturezaDaOcorrencia());
	}
}
