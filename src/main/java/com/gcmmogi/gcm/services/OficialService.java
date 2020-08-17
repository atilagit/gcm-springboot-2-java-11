package com.gcmmogi.gcm.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcmmogi.gcm.entities.Oficial;
import com.gcmmogi.gcm.entities.enums.Perfil;
import com.gcmmogi.gcm.repositories.OficialRepository;
import com.gcmmogi.gcm.security.UserSS;
import com.gcmmogi.gcm.services.exceptions.AuthorizationException;
import com.gcmmogi.gcm.services.exceptions.DatabaseException;
import com.gcmmogi.gcm.services.exceptions.ResourceNotFoundException;

@Service
public class OficialService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private OficialRepository repository;
	
	public List<Oficial> findAll(){
		return repository.findAll();
	}
	
	
	public Oficial findById(Long id) {
		UserSS user = UserService.authenticated();
		if(user==null || !user.hasRole(Perfil.ADMINISTRATIVO) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Oficial> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Oficial insert(Oficial obj) {
		obj.setId(null);
		obj.setSenha(pe.encode(obj.getSenha()));
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
	
	public Oficial update(Long id, Oficial obj) {
		try {
			Oficial entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Oficial entity, Oficial obj) {
		entity.setLogin(obj.getLogin());
		entity.setNome(obj.getNome());
		entity.setTime(obj.getTime());
		entity.setViatura(obj.getViatura());
		entity.setEmail(obj.getEmail());
		entity.getPerfis().clear();
		entity.getPerfis().add(Perfil.EM_CAMPO);
		for (Perfil p : obj.getPerfis()) {
			entity.addPerfil(p);
		}
	}
}
