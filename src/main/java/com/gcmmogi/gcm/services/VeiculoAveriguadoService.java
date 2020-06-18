package com.gcmmogi.gcm.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.VeiculoAveriguado;
import com.gcmmogi.gcm.repositories.VeiculoAveriguadoRepository;
import com.gcmmogi.gcm.services.exceptions.DatabaseException;
import com.gcmmogi.gcm.services.exceptions.ResourceNotFoundException;

@Service
public class VeiculoAveriguadoService {
	
	@Autowired
	private VeiculoAveriguadoRepository repository;
	
	public List<VeiculoAveriguado> findAll(){
		return repository.findAll();
	}
	
	public VeiculoAveriguado findById(Long id) {
		Optional<VeiculoAveriguado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public VeiculoAveriguado insert(VeiculoAveriguado obj) {
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
	
	public VeiculoAveriguado update(Long id, VeiculoAveriguado obj) {
		try {
			VeiculoAveriguado entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(VeiculoAveriguado entity, VeiculoAveriguado obj) {
		entity.setPlaca(obj.getPlaca());
		entity.setModelo(obj.getModelo());
		entity.setAno(obj.getAno());
		entity.setCor(obj.getCor());
		entity.setCodRenavam(obj.getCodRenavam());
		entity.setDano(obj.getDano());
	}
}
