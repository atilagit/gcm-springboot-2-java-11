package com.gcmmogi.gcm.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.Envolvido;
import com.gcmmogi.gcm.repositories.EnvolvidoRepository;
import com.gcmmogi.gcm.services.exceptions.DatabaseException;
import com.gcmmogi.gcm.services.exceptions.ResourceNotFoundException;

@Service
public class EnvolvidoService {
	
	@Autowired
	private EnvolvidoRepository repository;
	
	public List<Envolvido> findAll(){
		return repository.findAll();
	}
	
	public Envolvido findById(Long id) {
		try {
			Optional<Envolvido> obj = repository.findById(id);
			return obj.get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Envolvido insert(Envolvido obj) {
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

	public Envolvido update(Long id, Envolvido obj) {
		try {
			Envolvido entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Envolvido entity, Envolvido obj) {
		entity.setCondicaoDaParte(obj.getCondicaoDaParte());
		entity.setConduzido(obj.getConduzido());
		entity.setNome(obj.getNome());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setPai(obj.getPai());
		entity.setMae(obj.getMae());
		entity.setNacionalidade(obj.getNacionalidade());
		entity.setNaturalidadeCidade(obj.getNaturalidadeCidade());
		entity.setNaturalidadeEstado(obj.getNaturalidadeEstado());
		entity.setTelefone(obj.getTelefone());
		entity.setLocalDeTrabalho(obj.getLocalDeTrabalho());
		entity.setVersaoDoEnvolvido(obj.getVersaoDoEnvolvido());
	}
}
