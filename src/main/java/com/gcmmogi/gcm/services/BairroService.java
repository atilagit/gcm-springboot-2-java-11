package com.gcmmogi.gcm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.dto.BairroDTO;
import com.gcmmogi.gcm.entities.Bairro;
import com.gcmmogi.gcm.repositories.BairroRepository;
import com.gcmmogi.gcm.repositories.BoletimOcorrenciaRepository;
import com.gcmmogi.gcm.services.exceptions.DatabaseException;
import com.gcmmogi.gcm.services.exceptions.ResourceNotFoundException;

@Service
public class BairroService {
	
	@Autowired
	private BairroRepository repository;
	
	@Autowired
	private BoletimOcorrenciaRepository boletimrepository;
	
	public List<Bairro> findAll(){
		return repository.findAll();
	}
	
	public Bairro findById(Long id) {
		Optional<Bairro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
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
	
	public List<BairroDTO> topBairrosComMaisBO(){
		Integer quant = 5;
		List<Bairro> todosBairros = repository.findAll();
		
		todosBairros.sort((b1,b2) -> b2.getBoletins().size() - b1.getBoletins().size());
		todosBairros.removeIf(x -> todosBairros.indexOf(x) > quant-1);
		
		return toDTO(todosBairros);
	}

	private void updateData(Bairro entity, Bairro obj) {
		entity.setNome(obj.getNome());
	}
	
	public List<BairroDTO> toDTO(List<Bairro> obj) {
		Long totalDeBO = boletimrepository.count();
		List<BairroDTO> bairrosDTO = new ArrayList<>();
		for (Bairro b : obj) {
			Long quantidadeDeBOdoBairro = (long) b.getBoletins().size();
			Double percentual = Double.parseDouble(String.format(Locale.US, "%.1f", ((quantidadeDeBOdoBairro.doubleValue() / totalDeBO.doubleValue()) * 100)));
			BairroDTO bairroDTO = new BairroDTO(b.getId(), b.getNome(), quantidadeDeBOdoBairro, percentual);
			bairrosDTO.add(bairroDTO);
		}
		return bairrosDTO;
	}
}
